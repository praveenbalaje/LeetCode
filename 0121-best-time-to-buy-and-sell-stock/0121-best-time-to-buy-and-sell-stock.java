class Solution {
    public int maxProfit(int[] prices) {
        
        int[] max = new int[prices.length];


        for(int i = prices.length-1;i>=0;i--) {
            if(i == prices.length-1 || max[i+1] < prices[i]) {
                max[i] = prices[i];
            } else {
                max[i] = max[i+1];
            }
        }

        int profit = 0;

        for(int i=0;i<prices.length;i++) {
            int dayProfit = max[i] - prices[i];
            if(profit < dayProfit) {
                profit = dayProfit;
            }
        }

        return profit;
    }
}