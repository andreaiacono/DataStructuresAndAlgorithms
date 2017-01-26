package recursion;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class RobotInGrid {

    class Node {
        int col;
        int row;
        Node right;
        Node down;

        Node(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }

    @Test
    public void test() {

        boolean[][] grid = new boolean[][]{
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true, true, true, true},
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));


        grid = new boolean[][]{
                {true},
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  true,  true,  true},
                {false, false, false, true},
                {true,  true,  true,  true},
                {true,  false, false, false},
                {true,  true,  true,  true}
        };
        assertFalse(findPathOnGraph(grid));
        assertFalse(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  false, false, false},
                {true,  true,  false, false},
                {false, true,  true,  false},
                {false, false, true,  true},
                {false, false, false, true}
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  false, false, false},
                {true,  true,  false, false},
                {false, true,  true,  false},
                {false, false, true,  false},
                {false, false, true,  true}
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  false, true, true},
                {false, true,  true, true},
                {true,  true,  true, true},
                {true,  true,  true, true}
        };
        assertFalse(findPathOnGraph(grid));
        assertFalse(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  true, true, true},
                {false, true, true, false}
        };
        assertFalse(findPathOnGraph(grid));
        assertFalse(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true,  true,  true,  true},
                {false, false, false, true},
                {false, false, false, true},
                {false, false, false, true},
                {false, false, false, true}
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));

        grid = new boolean[][]{
                {true, false, false, false},
                {true, false, false, false},
                {true, false, false, false},
                {true, false, false, false},
                {true, true,  true,  true}
        };
        assertTrue(findPathOnGraph(grid));
        assertTrue(findPathBacktracking(grid));
    }

    boolean findPathBacktracking(boolean[][] grid) {

        return findPath(grid, 0, 0);
    }

    boolean findPath(boolean[][] grid, int row, int col) {

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }

        if (row < grid.length - 1 && grid[row + 1][col]) {
            return findPath(grid, row + 1, col);
        }

        if (col < grid[0].length - 1 && grid[row][col + 1]) {
            return findPath(grid, row, col + 1);
        }

        return false;
    }

    boolean findPathOnGraph(boolean[][] grid) {

        Node[][] graph = createGraph(grid);

        Node root = graph[0][0];
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        Set<Node> visited = new HashSet<>();
        visited.add(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.col == grid[0].length - 1 && current.row == grid.length - 1) {
                return true;
            }

            if (current.right != null && !visited.contains(current.right)) {
                visited.add(current.right);
                stack.push(current.right);
            }
            if (current.down != null && !visited.contains(current.down)) {
                visited.add(current.down);
                stack.push(current.down);
            }
        }

        return false;
    }

    Node[][] createGraph(boolean[][] grid) {
        Node[][] graph = new Node[grid.length][grid[0].length];

        for (int row = grid.length - 1; row >= 0; row--) {
            for (int col = grid[0].length - 1; col >= 0; col--) {

                if (grid[row][col]) {
                    Node node = new Node(row, col);
                    graph[row][col] = node;
                    if (col < grid[0].length - 1) {
                        node.right = graph[row][col + 1];
                    }
                    if (row < grid.length - 1) {
                        node.down = graph[row + 1][col];
                    }
                }
            }
        }

        return graph;
    }
}
