import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<>(current)); // Add current subset to the result

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates

            current.add(nums[i]); // Choose element
            backtrack(i + 1, nums, current, res); // Recurse
            current.remove(current.size() - 1); // Backtrack (undo the choice)
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2}));
    }
}
