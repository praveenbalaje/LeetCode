class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wcount = 0;
        int res = -1;
        for(int i=0;i<blocks.length();i++) {
            if(blocks.charAt(i) == 'W') {
                wcount += 1;
            }
            if(i >= k-1) {
                if(i > k-1 && blocks.charAt(i-k) == 'W') {
                    wcount -= 1;
                }

                if(res == -1 || res > wcount) {
                    res =  wcount;
                }

            }
        }
        return res;
    }
}