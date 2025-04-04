class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr[count++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int uni = arr[arr.length / 2];
        int ans = 0;
        int prev = 0;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if(value % x != uni %x) {
                return -1;
            }

            ans += Math.abs(uni - value) / x;

        }

        return ans;
    }
}