class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                    int prod = nums[i] * nums[j];
                    if (map.containsKey(prod)) {
                        int value = map.get(prod);
                        count += value;
                        value += 1;
                        map.put(prod,value);
                    } else {
                        map.put(prod, 1);
                    }
            }
        }

        return count*8;
    }
}