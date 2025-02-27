import java.util.HashMap;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // Store the index of each number in the array for quick lookups
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (i, j) to find Fibonacci-like subsequences
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int first = arr[i];   // First number of sequence
                int second = arr[j];  // Second number of sequence
                int length = 2;       // Initial sequence length

                // Continue forming the Fibonacci-like sequence
                while (indexMap.containsKey(first + second)) {
                    int next = first + second; // Compute next term
                    first = second;
                    second = next;
                    length++;
                }

                // Update the maximum length found
                maxLength = Math.max(maxLength, length);
            }
        }

        // A valid Fibonacci-like sequence must have at least 3 elements
        return maxLength > 2 ? maxLength : 0;
    }
}