class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int unique = 0;
        int same = 0;

        for (String word : words) {
            String reverse = "" + word.charAt(1) + word.charAt(0);

            if (freq.getOrDefault(reverse, 0) > 0) {
                unique += 4;
                freq.put(reverse, freq.get(reverse) - 1);
                
                if (reverse.equals(word)) {
                    same--;
                }
            } else {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
                
                if (word.equals(reverse)) {
                    same++;
                }
            }
        }

        if (same > 0) {
            unique += 2;
        }

        return unique;
    }
}
