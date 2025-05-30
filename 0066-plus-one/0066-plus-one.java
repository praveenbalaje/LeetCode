class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i=digits.length-1;i>=0;i--) {
            if(i == digits.length-1){
            digits[i] += 1;
            }
            digits[i] += carry;
             carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if(carry == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length+1];
            res[0] = carry;
            for(int i=1;i<res.length;i++){
                res[i] = digits[i-1];
            }
            return res;
        }
    }
}