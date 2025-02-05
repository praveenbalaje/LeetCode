class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int index = -1;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(index == -1) {
                    index = i;
                } else if(index >= 0 && s1.charAt(i) == s2.charAt(index) && s1.charAt(index) == s2.charAt(i)) {
                    index = -2;
                } else {
                    index = -3;
                }
            }
        }

        return index == -1 || index == -2;
    }
}