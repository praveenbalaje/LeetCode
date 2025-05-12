class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // Frequency array to count each digit (0-9)
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        // Loop through all 3-digit even numbers (100 to 998)
        for (int num = 100; num <= 999; num += 2) {
            int[] tempFreq = Arrays.copyOf(freq, freq.length);
            int val = num;
            boolean isValid = true;

            // Check if the current number can be formed from the digits
            for (int i = 0; i < 3; i++) {
                int digit = val % 10;
                if (tempFreq[digit] == 0) {
                    isValid = false;
                    break;
                }
                tempFreq[digit]--;
                val /= 10;
            }

            if (isValid) {
                result.add(num);
            }
        }

        // Convert the result list to an array
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}