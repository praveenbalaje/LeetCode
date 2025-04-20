class Solution {
    public int numRabbits(int[] answers) {
        int totalRabbits = 0;
        Map<Integer, Integer> answerCountMap = new HashMap<>();

        // Count how many times each answer appears
        for (int answer : answers) {
            answerCountMap.put(answer, answerCountMap.getOrDefault(answer, 0) + 1);
        }

        // Calculate the total number of rabbits
        for (Map.Entry<Integer, Integer> entry : answerCountMap.entrySet()) {
            int x = entry.getKey(); // the answer given by a rabbit
            int count = entry.getValue(); // how many rabbits gave this answer
            int groupSize = x + 1;

            // Number of groups needed = ceil(count / groupSize)
            int groups = (count + x) / groupSize;

            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}