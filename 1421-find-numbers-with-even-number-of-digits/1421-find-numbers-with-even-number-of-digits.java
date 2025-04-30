class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            int a = 0;
            while(nums[i] > 0) {
                nums[i] = nums[i] / 10;
                a++;
            }
            if(a%2 == 0) count++;
        }
        return count;
    }
}