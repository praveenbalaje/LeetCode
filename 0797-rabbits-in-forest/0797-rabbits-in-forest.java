class Solution {
    public int numRabbits(int[] answers) {
        int counter = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            mp.put(answers[i], mp.getOrDefault(answers[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            counter += count;
            int remainder = count % (value + 1);
            if (remainder != 0) {
                counter += (value + 1) - remainder;
            }
        }
        return counter;
    }
}