class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] !=0) {
                    int sum = visitLand(grid,0,i,j);
                    if(sum > res) {
                        res = sum;
                    }
                }

            }
        }

        return res;
    }

    private int visitLand(int[][] grid,int count,int i, int j) {
        if(grid[i][j] == 0) {
            return count;
        } else {
            count += grid[i][j];
            grid[i][j] = 0;
            if(i+1 < grid.length && grid[i+1][j] != 0) {
                count = visitLand(grid,count,i+1,j);
            } 
            if(j+1 < grid[0].length && grid[i][j+1] != 0) {
                count = visitLand(grid,count,i,j+1);
            }
            if(i-1 >= 0 && grid[i-1][j] != 0) {
                count = visitLand(grid,count,i-1,j);
            } 
            if(j-1 >=0 && grid[i][j-1] != 0) {
                count = visitLand(grid,count,i,j-1);
            }
        }
        return count;
    }
}