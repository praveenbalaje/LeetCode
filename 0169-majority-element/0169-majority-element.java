class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],1)+1);
            if(map.get(nums[i])>max) {
                res = nums[i];
                max = map.get(nums[i]);
            }
        }

        return res;
    }
}