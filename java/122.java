class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int bestBuyDay = 0;
        int potentialSellDay = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[potentialSellDay]) {
                maxProfit += prices[potentialSellDay] - prices[bestBuyDay];
                bestBuyDay = i;
                potentialSellDay = i;
            } else if (prices[i] > prices[potentialSellDay]) {
                potentialSellDay = i;
            }
        }
        maxProfit += prices[potentialSellDay] - prices[bestBuyDay];
        return maxProfit;
    }
}