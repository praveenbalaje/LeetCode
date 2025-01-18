class Solution {
    public int minCost(int[][] grid) {
         int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Directions for 1, 2, 3, 4
        Deque<int[]> deque = new ArrayDeque<>(); // Deque for 0-1 BFS
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize costs to infinity
        }
        cost[0][0] = 0;
        deque.add(new int[]{0, 0, 0}); // {row, col, cost}

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1], currentCost = current[2];

            // If we've already found a cheaper way to this cell, skip processing
            if (currentCost > cost[x][y]) continue;

            // Explore all four directions
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + directions[dir][0];
                int ny = y + directions[dir][1];
                int newCost = currentCost + (grid[x][y] == dir + 1 ? 0 : 1);

                // If the new cell is within bounds and offers a cheaper path
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    if (grid[x][y] == dir + 1) {
                        deque.addFirst(new int[]{nx, ny, newCost}); // No cost, push to front
                    } else {
                        deque.addLast(new int[]{nx, ny, newCost}); // Cost 1, push to back
                    }
                }
            }
        }

        // Return the minimum cost to reach the bottom-right cell
        return cost[m - 1][n - 1];
    }
}