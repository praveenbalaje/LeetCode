class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count =0 ;
        Map<String,Integer> freq = new HashMap<>();
        for(int i=0;i<dominoes.length;i++) {
            String a = "" + dominoes[i][0] + dominoes[i][1];
            String b = "" + dominoes[i][1] + dominoes[i][0];
            int c = freq.getOrDefault(a,0);
            int d = freq.getOrDefault(b,0);
            if(c > 0) {
                count += c;
                freq.put(a,c+1);
            } else if(d > 0) {
                count += d;
                freq.put(b,d+1);
            } else {
                freq.put(a,1);
            }
        }
        return count;
    }
}