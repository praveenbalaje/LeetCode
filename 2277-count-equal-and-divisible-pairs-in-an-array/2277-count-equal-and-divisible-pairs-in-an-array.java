class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer,List<Integer>> fm =  new HashMap<>();
        for(int i =0;i<nums.length;i++) {
            List<Integer> ls = fm.getOrDefault(nums[i], new ArrayList<Integer>());
            ls.add(i);
            fm.put(nums[i],ls);
        }

        int count = 0;

        for(Map.Entry<Integer,List<Integer>> entry : fm.entrySet()) {
            List<Integer> ls = entry.getValue();
            if(ls.size() == 1) continue;
            for(int i = 0; i< ls.size();i++) {
                for(int j = i+1;j<ls.size();j++) {
                    if((ls.get(i)*ls.get(j)) % k == 0) count ++;
                }
            }
        }

        return count;
    }
}