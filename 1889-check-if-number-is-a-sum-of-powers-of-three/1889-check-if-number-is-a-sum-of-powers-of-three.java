class Solution {
    public boolean checkPowersOfThree(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        int a =1;
        while(arr.get(arr.size() - 1) < n) {
            arr.add((int) Math.pow(3,a));
            a++;
        }   
        for (int i = arr.size()-1; i>=0; i--) {
            if(n>=arr.get(i)) {
                n -= arr.get(i);
            }
    }
    if(n == 0) return true;
     else return false;
    }
}