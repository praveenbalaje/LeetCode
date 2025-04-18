class Solution {
    public int largestIsland(int[][] grid) {
        int island = -1;
        int res = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    int count = traverse(grid, 0, i, j, island);
                    hm.put(island, count);
                    island--;
                    res = Math.max(res, count);
                }
            }
        }

        if (res > 0 && res != grid.length * grid.length) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    int sum = 0;
                    List<Integer> ls = new ArrayList<>();

                    if (grid[i][j] == 0) {
                        if (i + 1 < grid.length && grid[i + 1][j] != 0) {
                            sum += hm.get(grid[i + 1][j]);
                            ls.add(grid[i + 1][j]);
                        }
                        if (j + 1 < grid.length && grid[i][j + 1] != 0 && !ls.contains(grid[i][j + 1])) {
                            sum += hm.get(grid[i][j + 1]);
                            ls.add(grid[i][j + 1]);
                        }
                        if (i - 1 >= 0 && grid[i - 1][j] != 0 && !ls.contains(grid[i - 1][j])) {
                            sum += hm.get(grid[i - 1][j]);
                            ls.add(grid[i - 1][j]);
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] != 0 && !ls.contains(grid[i][j - 1])) {
                            sum += hm.get(grid[i][j - 1]);
                            ls.add(grid[i][j - 1]);
                        }
                    }

                    if (sum > res) {
                        res = sum;
                    }
                }
            } 
            return res + 1;
        } else if(res == 0) return 1;
        else return res;
    }

    private int traverse(int[][] grid, int count, int i, int j, int island) {
        if (grid[i][j] != 1) {
            return count;
        }

        count++;
        grid[i][j] = island;

        if (i + 1 < grid.length) {
            count = traverse(grid, count, i + 1, j, island);
        }
        if (j + 1 < grid.length) {
            count = traverse(grid, count, i, j + 1, island);
        }
        if (i - 1 >= 0) {
            count = traverse(grid, count, i - 1, j, island);
        }
        if (j - 1 >= 0) {
            count = traverse(grid, count, i, j - 1, island);
        }

        return count;
    }
}