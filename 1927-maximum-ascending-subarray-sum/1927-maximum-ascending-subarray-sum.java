class Solution {

    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            count += nums[i];
            if(i+1<nums.length && nums[i] >= nums[i+1]) {
                if(count > sum) {
                    sum = count;
                }
                count = 0;
            } 
        }
         if(count > sum) {
            sum = count;
         }
        return sum;
    }
}