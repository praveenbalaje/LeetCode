class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int digitSum = 0;
            int num = nums[i];
            while(num > 0) {
                digitSum += num %10;
                num = num / 10;
            }
            ArrayList<Integer> list = map.getOrDefault(digitSum, new ArrayList<Integer>());
            list.add(nums[i]);
            map.put(digitSum,list);
        }

        int res = -1;

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            if(list.size() > 1) {
                Collections.sort(list, Collections.reverseOrder());
                 int sum = list.stream()
                          .limit(2)  // Take first 2 elements
                          .mapToInt(Integer::intValue)  // Convert to int
                          .sum();  // Sum the values

                if(sum > res) {
                    res = sum;
                }
            }
        }

        return res;
    }
}