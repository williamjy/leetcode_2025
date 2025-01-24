class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int bestBuyDay = 0;
        int bestSellDay = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[bestBuyDay]) {
                bestBuyDay = i;
                bestSellDay = i;  
            } else if (prices[i] > prices[bestSellDay]) {
                bestSellDay = i;
                if (prices[bestSellDay] - prices[bestBuyDay] > maxProfit) {
                    maxProfit = prices[bestSellDay] - prices[bestBuyDay];
                }
            }
        }
        return maxProfit;
    }
}