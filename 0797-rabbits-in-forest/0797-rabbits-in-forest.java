class Solution {
    public int numRabbits(int[] answers) {
        int counter = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            int value = mp.getOrDefault(answers[i], 0) + 1;
            mp.put(answers[i], value);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            counter += count;
            if ((count % (value + 1) != 0)) {
                counter += (value + 1) - (count % (value + 1));
            }
            System.out.println(
                    "value : " + value + " count  : " + count + " mod : " + ((value + 1) - (count % (value + 1))));
        }
        return counter;
    }
}