class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> source = new LinkedHashSet<>();
        for (int next : nums)
            source.add(next);
        List<List<Integer>> res = new ArrayList<>();
        permute(source, new ArrayList<>(), res);
        return res;
    }

    public static void permute(Set<Integer> source, List<Integer> answer,
            List<List<Integer>> result) {

        if (source.isEmpty()) {
            result.add(answer);
            return;
        }

        for (Integer next : source) {
            List<Integer> updatedAnswer = new ArrayList<>(answer);
            updatedAnswer.add(next);
            Set<Integer> updatedSource = new LinkedHashSet<>(source);
            updatedSource.remove(next);
            permute(updatedSource, updatedAnswer, result);
        }
    }
}