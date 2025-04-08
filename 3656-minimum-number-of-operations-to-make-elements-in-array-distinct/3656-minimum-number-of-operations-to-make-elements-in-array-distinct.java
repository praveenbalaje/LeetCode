class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], (freq.getOrDefault(nums[i], 0)) + 1);
        }

        while ((freq.size() + (count * 3)) < nums.length) {
            int index = count * 3;
            // System.out.println(freq.size() + (count * 3));
            for (int i = index; i < index + 3 && i < nums.length; i++) {
                int prev = freq.get(nums[i]);
                if (prev == 1) {
                    freq.remove(nums[i]);
                } else {
                    freq.put(nums[i], prev - 1);
                }
            }
            count++;
        }

        return count;

    }
}