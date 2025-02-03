class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 0;
        int decreasing = 0;
        int max = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1]) {
                increasing +=1;
            } else {
                if(increasing > max) {
                    max = increasing;
                }
                increasing = 0;
            }

            if(nums[i] < nums[i+1]) {
                decreasing +=1;
            } else {
                if(decreasing > max) {
                    max = decreasing;
                }
                decreasing = 0;
            }
        }
        if(increasing > max) {
            max = increasing;
        }
        if(decreasing > max) {
            max = decreasing;
        }
        return max+1;
    }
}