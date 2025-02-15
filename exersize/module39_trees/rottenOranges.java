package exersize.module39_trees;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public static int minTimeToRot(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        // Step 1: Collect all initially rotten oranges and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j }); // Rotten orange positions
                } else if (grid[i][j] == 1) {
                    fresh++; // Count fresh oranges
                }
            }
        }

        // Directions for adjacent cells (Up, Down, Left, Right)
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // Step 2: Perform BFS
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0], newCol = c + dir[1];

                    // If it's a fresh orange, rot it
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.offer(new int[] { newRow, newCol });
                        fresh--; // Reduce fresh orange count
                    }
                }
            }
        }

        // Step 3: If there are still fresh oranges left, return -1
        return (fresh == 0) ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        System.out.println("Minimum time required to rot all oranges: " + minTimeToRot(grid));
    }
}
