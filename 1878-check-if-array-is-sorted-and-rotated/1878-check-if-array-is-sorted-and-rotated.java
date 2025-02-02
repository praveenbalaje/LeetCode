class Solution {
    public boolean check(int[] nums) {
        boolean res = true;
        int index = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1]){
                index = i+1;
                break;
            }
        }

        System.out.println(index);

        for(int i=0;i<nums.length-1;i++) {
            if(nums[(index+i) % nums.length] > nums[(index+i+1) % nums.length]){
                res = false;
                break;
            }
        }

        return res;
    }
}