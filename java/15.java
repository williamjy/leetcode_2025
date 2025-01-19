class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j != k;) {
                int currentSum = nums[i] + nums[j] + nums[k];
                if (currentSum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k]));
                    resultSet.add(triplet);
                    j++;
                } else if (currentSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        for (List<Integer> triplet : resultSet) {
            result.add(triplet);
        }
        return result;
    }
}