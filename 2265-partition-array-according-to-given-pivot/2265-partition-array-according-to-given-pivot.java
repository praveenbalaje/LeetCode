class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int more[] = new int[nums.length];
        int res[] = new int[nums.length];
        int j =0 ,k = 0 ,count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<pivot) {
                res[j] = nums[i];
                j++;
            } else if(nums[i] > pivot) {
                more[k] = nums[i];
                k++;
            } else {
                count++;
            }
        }
        while(count > 0) {
            res[j] = pivot;
            j++;
            count--;
        }
        int a = 0;
        while(j < nums.length) {
            res[j] = more[a];
            j++;
            a++;
        }

        return res;
    }
}