class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        boolean res = true;
        int arr[] = new int[nums.length];
        for(int i=0;i<queries.length;i++) {
            arr[queries[i][0]]--;
            if((queries[i][1]+1)<nums.length){
                arr[queries[i][1]+1]++;
            }
        }
        for(int i=0;i<arr.length;i++) {
            System.out.println("i : "+ i + " arr : "+ arr[i]);
        }
        int diff = 0;
        for(int i=0;i<nums.length;i++) {
            diff += arr[i];
            nums[i] = nums[i] + diff;
            if(nums[i] > 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}