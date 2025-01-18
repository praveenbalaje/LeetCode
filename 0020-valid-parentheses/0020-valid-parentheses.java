class Solution {
    public boolean isValid(String s) {

        String res = "";

        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char end = ' ';
            if (res.length() > 0) {
                end = res.charAt(res.length() - 1);
            }
            if (a == '(' || a == '{' || a == '[') {
                res += a;
            } else if ((a == ')' && end == '(')
                    || (a == ']' && end == '[')
                    || (a == '}' && end == '{')) {
                res = res.substring(0, res.length() - 1);
            } else {
                valid = false;
                break;
            }
        }

        if (res.length() > 0) {
            valid = false;
        }

        return valid;
    }
}