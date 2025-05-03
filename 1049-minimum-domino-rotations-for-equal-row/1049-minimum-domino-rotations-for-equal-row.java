class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count = -1;
        for(int i = 1;i <= 6; i++ ) {
            int a = 0;
            int b = 0;
            for(int j =0; j< tops.length; j++) {
                if(tops[j] != i && bottoms[j] == i) {
                    a++;
                } else if(tops[j] == i && bottoms[j] != i) {
                    b++;
                } else if(tops[j] != i && bottoms[j] != i) {
                    a = -1;
                    break;
                }
            }
            if(a != -1) {
                count = Math.min(a,b);
            }

        }

        return count;
    }
}