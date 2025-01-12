class Solution {
    public int maxArea(int[] height) {
       List<Integer> indexList = new ArrayList<Integer>();
       int maxAmount = 0;
       for (int i = 0; i < height.length; i++) {
            int rightHeight = height[i];
            for (Integer j : indexList) {
                int leftHeight = height[j];
                int absoluteHeight = leftHeight;
                if (rightHeight < absoluteHeight) {
                    absoluteHeight = rightHeight;
                }
                int amount = absoluteHeight * (i - j);
                if (amount > maxAmount) {
                    maxAmount = amount;
                }
            }
            if (indexList.isEmpty() || rightHeight > height[indexList.get(indexList.size() - 1)]) {
                indexList.add(i);
            }
       }
       return maxAmount;
    }
}