class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        for(int i=1;i<nums.length;i++) {
            maxEnding = Math.max(maxEnding+nums[i],nums[i]);
            minEnding = Math.min(minEnding+nums[i],nums[i]);
            if(maxEnding > res) {
                res = maxEnding;
            }
            if(Math.abs(minEnding) > res) {
                res = Math.abs(minEnding);
            }
        }
        return Math.abs(res);
    }
}