class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1; // Tracks length of increasing subarray
        int decreasing = 1; // Tracks length of decreasing subarray
        int max = 1; // Stores the max length found
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing += 1;
                decreasing = 1; // Reset decreasing since sequence is increasing
            } else if (nums[i] < nums[i - 1]) {
                decreasing += 1;
                increasing = 1; // Reset increasing since sequence is decreasing
            } else {
                increasing = 1;
                decreasing = 1; // Reset both when equal elements are found
            }
            max = Math.max(max, Math.max(increasing, decreasing));
        }
        
        return max;
    }
}