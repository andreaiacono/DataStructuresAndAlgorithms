package recursion;

import java.util.*;

public class WaterPouring {

    public static void main(String[] args) {
        new WaterPouring(new Integer[]{5, 3}, 4);
    }

    public WaterPouring(Integer[] glasses, int desiredGoal) {

        // setup vars
        int goal = desiredGoal;
        State state = new State(glasses);

        // prints output
        System.out.println("Water pouring problem.\nGlasses:");
        for (int j = 0; j < glasses.length; j++) System.out.println("Glass #" + j + ": " + glasses[j]);

        // calls the solvers
        Moves result = solver(state, new Moves(new ArrayList<>()), new VisitedStates(new HashSet<>()), goal);
        Moves bfsResult = bfsSolver(state, goal);

        // prints results
        System.out.println("Result: " + result);
        System.out.println("BFS Result: " + bfsResult);
    }

    /**
     * approaches the problem as a search problem, with a BFS approach
     *
     * @param initialState
     * @param goal
     * @return
     */
    private Moves bfsSolver(State initialState, int goal) {

        Set<State> visitedStates = new HashSet<>();
        Queue<Moves> toBeVisited = new LinkedList<>();
        Moves moves = new Moves();
        toBeVisited.add(moves.addMove(initialState));

        while (!toBeVisited.isEmpty()) {

            Moves actualMoves = toBeVisited.poll();
            State state = actualMoves.states.get(actualMoves.states.size() - 1);
            visitedStates.add(state);

            if (state.isGoal(goal)) {
                return actualMoves;
            }

            for (int j = 0; j < state.getLength(); j++) {
                State newState = state.empty(j);
                if (!visitedStates.contains(newState)) toBeVisited.add(actualMoves.addMove(newState));

                newState = state.fill(j);
                if (!visitedStates.contains(newState)) toBeVisited.add(actualMoves.addMove(newState));

                for (int i = 0; i < state.getLength(); i++) {
                    if (i != j) {
                        newState = state.pour(j, i);
                        if (!visitedStates.contains(newState)) toBeVisited.add(actualMoves.addMove(newState));
                    }
                }
            }
        }
        return new Moves();
    }

    /**
     * traditional recursive approach for solving the problem
     * @param state
     * @param moves
     * @param visitedStates
     * @param goal
     * @return
     */
    private Moves solver(State state, Moves moves, VisitedStates visitedStates, int goal) {

        if (visitedStates.contains(state)) {
            return null;
        }

        visitedStates = visitedStates.addVisitedState(state);

        if (state.isGoal(goal)) {
            return moves;
        }

        for (int j = 0; j < state.getLength(); j++) {

            State newState = state.fill(j);
            Moves result = solver(newState, moves.addMove(newState), visitedStates, goal);
            if (result != null) return result;

            newState = state.empty(j);
            result = solver(newState, moves.addMove(newState), visitedStates, goal);
            if (result != null) return result;

            for (int i = 0; i < state.getLength(); i++) {
                if (i != j) {
                    newState = state.pour(j, i);
                    result = solver(newState, moves.addMove(newState), visitedStates, goal);
                    if (result != null) return result;
                }
            }
        }
        return null;
    }

    /**
     * represent a state in the problem search space: the set of water levels of the jugs
     */
    class State {

        private Integer[] state;
        private Integer[] capacity;

        public State(Integer[] fromState, Integer[] capacity) {
            this.capacity = capacity;
            this.state = Arrays.copyOf(fromState, fromState.length);
        }

        public State(Integer[] capacity) {
            this.capacity = capacity;
            this.state = new Integer[capacity.length];
            for (int i = 0; i < capacity.length; i++) this.state[i] = 0;
        }

        public State empty(int index) {
            State newState = new State(state, capacity);
            newState.setValue(index, 0);
            return newState;
        }

        public State fill(int index) {
            State newState = new State(state, capacity);
            newState.setValue(index, capacity[index]);
            return newState;
        }

        public State pour(int from, int to) {
            State newState = new State(state, capacity);
            if (newState.getValue(from) + newState.getValue(to) > capacity[to]) {
                newState.setValue(from, newState.getValue(from) - (capacity[to] - newState.getValue(to)));
                newState.setValue(to, capacity[to]);
            }
            else {
                newState.setValue(to, newState.getValue(to) + newState.getValue(from));
                newState.setValue(from, 0);
            }

            return newState;
        }

        public boolean isGoal(int goal) {
            return Arrays.stream(state).anyMatch(n -> n == goal);
        }

        public void setValue(int index, int value) {
            state[index] = value;
        }

        public Integer getValue(int index) {
            return state[index];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State other = (State) o;
            for (int j = 0; j < other.getLength(); j++) {
                if (state[j] != other.getValue(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(state);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[");
            Arrays.stream(state).forEach(s -> builder.append(s).append(", "));
            builder.delete(builder.length() - 2, builder.length());
            return builder.append("]").toString();
        }

        public int getLength() {
            return state.length;
        }
    }

    class Moves {
        private ArrayList<State> states;

        public Moves() {
            states = new ArrayList<>();
        }

        public Moves(ArrayList<State> states) {
            this.states = states;
        }

        public Moves addMove(State state) {
            ArrayList<State> newMoves = new ArrayList<>(states);
            newMoves.add(state);
            return new Moves(newMoves);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("Moves { ");
            states.stream().forEach(s -> builder.append(s).append(", "));
            return builder.append("}").toString();
        }
    }

    class VisitedStates {
        private Set<State> states;

        public VisitedStates(Set<State> states) {
            this.states = states;
        }

        public VisitedStates addVisitedState(State state) {
            Set<State> newVisitedStates = new HashSet<>(states);
            newVisitedStates.add(state);
            return new VisitedStates(newVisitedStates);
        }

        public boolean contains(State element) {
            for (State state : states) {
                if (state.equals(element)) return true;
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("VisitedStates { ");
            states.stream().forEach(s -> builder.append(s).append(", "));
            return builder.append("}").toString();
        }
    }
}


