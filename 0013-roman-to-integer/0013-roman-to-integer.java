class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++) {

            char current = s.charAt(i);
            char next = ' ';
            if(i+1 < s.length()) {
                next = s.charAt(i+1);
            }

            int currentValue = getValue(current);
            int nextValue = getValue(next);
            if(nextValue > currentValue)
            {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }

            
        }

        return sum;
    }

    private int getValue(char s) {
        if(s == 'I') return 1;
        else if(s == 'V') return 5;
        else if(s == 'X') return 10;
        else if(s == 'L') return 50;
        else if(s == 'C') return 100;
        else if(s == 'D') return 500;
        else if(s == 'M') return 1000;
        else return 0;
    }
}