class Solution {
    public String findDifferentBinaryString(String[] nums) {
        ArrayList<String> res = new ArrayList<>();
        List<String> num =  Arrays.asList(nums);
        System.out.println(num);
        permutate(nums[0].length(), "" , res,num);
        System.out.println(res);
        return res.get(0);
    }

    private void permutate(int n,String cur, ArrayList<String> res,List<String> num) {
        System.out.println(num + " cur :  " + cur);
        if(cur.length() == n) {
            if(!num.contains(cur)){
                res.add(cur);
            }
            return;
        }
         for (char ch : new char[]{'0', '1'}) {
            // if (cur.isEmpty() ) {
                if(res.size() == 0) {
                permutate(n, cur + ch, res,num);
                }
            // }
        }
    }
}