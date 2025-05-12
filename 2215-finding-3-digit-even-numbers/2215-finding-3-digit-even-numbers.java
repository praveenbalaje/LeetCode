class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int freq[] = new int[10];
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<digits.length;i++) {
            freq[digits[i]] += 1;
        }
        for(int i=0;i<=9;i++){
            System.out.println(i + " : " + freq[i]);
        }
        for(int i=100;i<1000;i++) {
            if(i % 2 == 0) {
                int val = i;
                int bk[] = Arrays.copyOf(freq, freq.length);;
                boolean b = true;
                while(val>0) {
                    int rem = val % 10;
                        System.out.println(rem + "  :  " + freq[rem]);
                    if(bk[rem] > 0) {
                        bk[rem] -= 1;
                    } else {
                        b = false;
                        break;
                    }
                    val = val /10;
                }
                if(b) ls.add(i);

            }
        }

        int res[] = new int[ls.size()];
        for(int i=0;i<ls.size();i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}