class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;

        for(int i=0;i+needle.length()<=haystack.length();i++) {
            String sub = haystack.substring(i,i+needle.length());
            System.out.println(sub);
            if(sub.equals(needle)){
                index = i;
                break;
            }
        }

        return index;
    }
}