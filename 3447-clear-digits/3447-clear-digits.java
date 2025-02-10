class Solution {
    public String clearDigits(String s) {
        String res = "";

        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                res = res.substring(0,res.length() - 1);
            } else {
                res = res + s.charAt(i);
            }
        }

        return res;
    }
}