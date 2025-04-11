class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count =0;
        for(int i=low;i<=high;i++) {
            if(checkNumber(i)) count++;
        }
        return count;
    }

    public boolean checkNumber(int num) {
        String s = "" + num;
        int sum = 0;
        if(s.length() % 2 == 1) return false;
        while(num > 0) {
           String s1 = "" + num;
            if(s1.length() <= s.length()/2) {
                sum += num % 10;
            } else {
                sum -= num % 10;
            }
            num = num /10;
        }
        return sum == 0;
    }
}