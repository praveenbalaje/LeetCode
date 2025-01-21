class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Define suffix and prefix arrays
        long[] suffix = new long[n];
        long[] prefix = new long[n];

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        // Fill the suffix array (starting from the last column of the top row)
        suffix[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i > 0; i--) {
            suffix[i] = suffix[i + 1] + grid[0][i];
        }

        // Fill the prefix array (starting from the first column of the bottom row)
        prefix[0] = grid[1][0];
        for (int i = 1; i < n - 1; i++) {
            prefix[i] = prefix[i - 1] + grid[1][i];
        }

        // Find the minimum possible points for the second robot
        for (int i = 0; i < n; i++) {
            long before = (i > 0) ? prefix[i - 1] : 0;
            long after = (i < n - 1) ? suffix[i + 1] : 0;
            max = Math.max(after, before);
            min = Math.min(min, max);
        }

        return min;
    }
}