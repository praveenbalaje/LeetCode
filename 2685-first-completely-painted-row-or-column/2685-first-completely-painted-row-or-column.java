class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int index = -1;
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        int[] position = new int[(m * n) + 1]; // storing the postion of the matrix array

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = (i * n) + j;
                position[mat[i][j]] = value;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int pos = position[value];
            row[pos / n] += 1;
            col[pos % n] += 1;

            if (row[pos / n] == col.length || col[pos % n] == row.length) {
                index = i;
                break;
            }
        }
        return index;
    }
}