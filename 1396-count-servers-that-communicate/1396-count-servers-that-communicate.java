class Solution {
    public int countServers(int[][] grid) {
        int col[] = new int[grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            int previousRow = -1;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (previousRow == -1) {
                        previousRow = j;
                    } else {
                        if (grid[i][previousRow] == 1) {
                            count += 2;
                        } else {
                            count += 1;
                        }

                        col[previousRow] = 2;
                        grid[i][previousRow] = 2;
                        grid[i][j] = 2;
                        previousRow = j;
                    }
                }

                if (grid[i][j] != 0) {

                    if (grid[i][j] == 1 && col[j] == 1) {
                        count += 2;
                        grid[i][j] = 2;
                        col[j] = 2;
                    } else if (grid[i][j] == 2 && col[j] == 1) {
                        count += 1;
                        col[j] = 2;
                    } else if (grid[i][j] == 1 && col[j] == 2) {
                        count += 1;
                        grid[i][j] = 2;
                    } else {
                        col[j] = grid[i][j];
                    }
                }
            }
        }
        return count;
    }
}