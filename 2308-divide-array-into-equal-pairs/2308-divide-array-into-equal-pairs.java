class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], val);
            if (val % 2 == 1)
                count++;
            else
                count--;
        }

        return count == 0;

    }
}