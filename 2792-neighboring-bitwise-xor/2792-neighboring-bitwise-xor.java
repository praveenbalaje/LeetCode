class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for(int i=0;i<derived.length;i++) {
            res = res ^ derived[i];
        }
        return res == 0;
    }
}