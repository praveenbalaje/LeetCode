class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) { // Start DFS on water cells
                    int sum = visitWater(grid, 0, i, j);
                    if (sum > res) {
                        res = sum; // Update the maximum fish count
                    }
                }
            }
        }
        return res;
    }

    private int visitWater(int[][] grid, int count, int i, int j) {
        if (grid[i][j] == 0) { // Base case: water or visited cell
            return count;
        } else {
            count += grid[i][j]; // Add fish count
            grid[i][j] = 0; // Mark as visited
            // Explore adjacent cells
            if (i + 1 < grid.length) {
                count = visitWater(grid, count, i + 1, j);
            }
            if (j + 1 < grid[0].length) {
                count = visitWater(grid, count, i, j + 1);
            }
            if (i - 1 >= 0) {
                count = visitWater(grid, count, i - 1, j);
            }
            if (j - 1 >= 0) {
                count = visitWater(grid, count, i, j - 1);
            }
        }
        return count;
    }
}