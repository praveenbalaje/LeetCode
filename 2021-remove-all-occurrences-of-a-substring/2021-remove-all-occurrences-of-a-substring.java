class Solution {
    public String removeOccurrences(String s, String part) {
        boolean retry = true;
        while (retry) {
            retry = false;
            for (int i = 0; i + part.length() <= s.length(); i++) {
                String sub = s.substring(i, i + part.length());
                if (sub.equals(part)) {
                    s = s.substring(0, i) + s.substring(i + part.length());
                    retry = true;
                    break;
                }
            }
        }

        return s;

    }
}