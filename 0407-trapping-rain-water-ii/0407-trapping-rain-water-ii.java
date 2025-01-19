import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        int totalWater = 0;

        // Min-heap (priority queue)
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Visited array to mark cells
        boolean[][] visited = new boolean[m][n];

        // Add all the boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        // Directions for 4 neighbors (up, down, left, right)
        int[] directions = { -1, 0, 1, 0, -1, 0 };

        // Process the cells in the priority queue
        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            // Explore the 4 neighbors
            for (int i = 0; i < 4; i++) {
                int x = current.x + directions[i];
                int y = current.y + directions[i + 1];

                // Skip if out of bounds or already visited
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                    continue;
                }

                // Calculate trapped water at the neighboring cell
                totalWater += Math.max(0, current.height - heightMap[x][y]);

                // Update the height of the neighboring cell and mark as visited
                pq.offer(new Cell(x, y, Math.max(heightMap[x][y], current.height)));
                visited[x][y] = true;
            }
        }

        return totalWater;
    }

    // Cell class to store coordinates and height
    private static class Cell {
        int x, y, height;

        Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
