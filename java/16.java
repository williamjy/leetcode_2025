class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j != k;) {
                int currentSum = nums[i] + nums[j] + nums[k];
                int closestDistance = target - closestSum;
                if (closestDistance < 0) {
                    closestDistance = -closestDistance;
                }
                int currentDistance = target - currentSum;
                if (currentDistance < 0) {
                    currentDistance = -currentDistance;
                }
                if (currentDistance == 0) {
                    return currentSum;
                } else if (currentSum < target) {
                    j++;
                } else if (currentSum > target) {
                    k--;
                }
                if (currentDistance < closestDistance) {
                    closestSum = currentSum;
                }
            }
        }
        return closestSum;
    }
}