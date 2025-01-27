class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int leftMin = prices[0];
        int rightMax = prices[length - 1];
        int[] leftMaxs = new int[length];
        int[] rightMaxs = new int[length + 1];
        for (int i = 1; i < length; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
            int j = length - i;
            rightMaxs[j] = Math.max(rightMaxs[j + 1], rightMax - prices[j]);
            rightMax =  Math.max(rightMax, prices[j]);
        }
        int maxProfit = 0;
        for (int i = 0; i < length ; i++) {
            int currProfit = leftMaxs[i] + rightMaxs[i + 1];
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}