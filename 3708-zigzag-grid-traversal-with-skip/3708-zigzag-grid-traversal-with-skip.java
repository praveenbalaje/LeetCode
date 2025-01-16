class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {

        List<Integer> res = new ArrayList();

        for(int i=0;i<grid.length;i++) {
            if(i%2 == 0) {
                for(int j=0;j<grid[i].length;j++) {
                    if((i+j) % 2 == 0 ) {
                        res.add(grid[i][j]);
                    }
                }
            } else {
                for(int j=grid[i].length-1;j>=0;j--) {
                    if((i+j) % 2 == 0 ) {
                        res.add(grid[i][j]);
                    }
                }
            }
        }

        return res;
        
    }
}