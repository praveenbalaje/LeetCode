class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-97]++;
        }
        int even = Integer.MAX_VALUE;
        int odd = 0;
        for(int i=0;i<freq.length;i++) {
            if(freq[i] % 2 == 0 && freq[i] < even  && freq[i] > 1) {
                System.out.println(i + " : " + freq[i]);
                even = freq[i];
            } else if(freq[i] % 2 != 0 && freq[i] > odd ) {
                odd = freq[i];
            }
        }
        System.out.println("even : "+ even);
        return odd-even;
    }
}