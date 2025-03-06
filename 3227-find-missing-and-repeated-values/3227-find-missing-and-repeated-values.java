class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[(grid.length * grid.length)+1];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                arr[grid[i][j]]++;
            }
        }

        int res[] = new int[2];
        for(int i=1;i<arr.length;i++) {
            if(arr[i] == 0) {
                res[1] = i;
            } else if(arr[i] > 1) {
                res[0] = i;
            }
        }

        return res;

    }
}