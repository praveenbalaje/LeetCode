class Solution {
    public int reverse(int x) {
        long res = 0L;
        while(x != 0) {
            res = (x%10) + (res *10);
            x = x/10;
        }

        if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
            int ans = (int) res;
            return ans;
        } else {
            return 0;
        }
    }
}