class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++)total += nums[i];
        if(total % 2 == 1) return false;
        int target = total/2;
        boolean[] res = new boolean[target+1];
        res[0] = true;
        for(int i=0;i<nums.length;i++) {
            for(int j=target;j >= nums[i];j--) {
                if(res[j-nums[i]]) {
                    res[j] = true;
                }
                if(res[target]) break;
            }
            if(res[target]) break;
        }
        for(int i=0;i<res.length;i++) {
            System.out.println(i + " " + res[i]);
        }
        return res[target];
    }
}