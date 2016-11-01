package recursion;

import java.util.*;

public class TowerOfHanoi {

    Deque<Integer>[] pegs;
    private final int pegsNumber = 3;
    private int disks;
    private List<Move> moves = new ArrayList<>();

    public TowerOfHanoi(int disks) {
        this.disks = disks;
        pegs = new ArrayDeque[pegsNumber];
        for (int j = 0; j < pegsNumber; j++) pegs[j] = new ArrayDeque<>(disks);
        for (int j = disks; j > 0; j--) pegs[0].push(j);
        System.out.println("Start:\n" + this);
    }

    public List<Move> solve() {
        tower(pegs, disks, 0, pegsNumber - 1);
        return moves;
    }

    private void tower(Deque<Integer>[] pegs, int disks, int startingPeg, int endingPeg) {
        swapDisks(pegs, disks, startingPeg, endingPeg);
    }

    private void swapDisks(Deque<Integer>[] pegs, int disks, int startingPeg, int destinationPeg) {
        int other = getOtherPeg(startingPeg, destinationPeg);

        // the base case
        if (disks == 2) {
            moveDisk(pegs, startingPeg, other);
            moveDisk(pegs, startingPeg, destinationPeg);
            moveDisk(pegs, other, destinationPeg);
            return;
        }

        // recurse case
        swapDisks(pegs, disks - 1, startingPeg, other);
        moveDisk(pegs, startingPeg, destinationPeg);
        swapDisks(pegs, disks - 1, other, destinationPeg);
    }

    private void moveDisk(Deque<Integer>[] pegs, int from, int to) {
        int disk = pegs[from].pop();
        pegs[to].push(disk);
        moves.add(new Move(from, to, disk));
        System.out.println("\n\n" + new Move(from, to, disk));
        System.out.println(this);
    }

    private int getOtherPeg(int startingPeg, int destinationPeg) {
        int[][] others = new int[3][3];
        others[0] = new int[]{0, 2, 1};
        others[1] = new int[]{2, 1, 0};
        others[2] = new int[]{1, 0, 2};
        return others[startingPeg][destinationPeg];
    }

    @Override
    public String toString() {
        int pegSize = disks * 2 + 1;
        int hanoiWidth = (pegSize + 1) * pegs.length;
        int height = disks;
        StringBuilder builder = new StringBuilder("\n");

        ArrayList<Integer>[] pegsLists = new ArrayList[pegs.length];
        for (int j = 0; j < pegs.length; j++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            Deque<Integer> peg = pegs[j];
            Iterator<Integer> iterator = peg.iterator();
            while (iterator.hasNext()) {
                int size = iterator.next();
                tmp.add(size);
            }
            pegsLists[j] = new ArrayList<>();
            for (int i = tmp.size(); i < height; i++) pegsLists[j].add(0);
            pegsLists[j].addAll(tmp);
        }

        String row = "";

        // the top empty pegs
        for (int i = 0; i < pegsLists.length; i++) {
            row += repeatChar(' ', pegSize / 2 - 1) + "|" + repeatChar(' ', pegSize / 2 - 1);
        }
        builder.append(row).append("\n");

        // the pegs with disks
        for (int j = 0; j < height; j++) {
            row = "";

            for (int i = 0; i < pegsLists.length; i++) {
                int diskSize = pegsLists[i].get(j);
                if (diskSize == 0) {
                    row += repeatChar(' ', (pegSize - diskSize) / 2 - 1);
                    row += repeatChar(' ', diskSize - 1) + '|' + repeatChar(' ', diskSize - 1);
                    row += repeatChar(' ', (pegSize - diskSize) / 2 - 1);
                }
                else {
                    row += repeatChar(' ', (pegSize - diskSize * 2) / 2) + repeatChar('+', diskSize * 2 - 1) + repeatChar(' ', (pegSize - diskSize * 2) / 2);
                }
            }
            builder.append(row).append("\n");
        }

        builder.append(repeatChar('_', hanoiWidth));
        return builder.toString();
    }

    private String repeatChar(char c, int times) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < times; j++) builder.append(c);
        return builder.toString();
    }

    class Move {
        int sourcePeg;
        int destinationPeg;
        int diskSize;

        public Move(int sourcePeg, int destinationPeg, int diskSize) {
            this.sourcePeg = sourcePeg;
            this.destinationPeg = destinationPeg;
            this.diskSize = diskSize;
        }

        @Override
        public String toString() {
            return "(" + diskSize + "): " + sourcePeg + "->" + destinationPeg;
        }
    }
}
