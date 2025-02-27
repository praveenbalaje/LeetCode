class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< arr.length; i++) {
            map.put(arr[i],i);
        }

        System.out.println(map);

        for(int i=0;i< arr.length-1; i++) {

        for(int l=i;l<arr.length-1;l++) {
            int j = i;
            int k = l+1;
            int sum = arr[j] + arr[k];
            int seq = 0;
            while(map.containsKey(sum)) {
                System.out.println(sum + " i : " + i);
                int value = map.get(sum);
                j = k;
                k = value;
                sum = arr[j] + arr[k];
                seq += 1;
            }

            if(seq>0 && seq+2 > res) res = seq+2;
        }


        }

        return res;

    }
}