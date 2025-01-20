class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int x = 0; x < nums.length - 3; x++) {
            for (int i = x + 1; i < nums.length - 2; i++) {
                for (int j = i + 1, k = nums.length - 1; j != k;) {
                    Long currentSum = Long.valueOf(nums[x]) + Long.valueOf(nums[i]) + Long.valueOf(nums[j])+ Long.valueOf(nums[k]);
                    Long targetCopy = Long.valueOf(target);
                    if (currentSum.equals(targetCopy)) {
                        List<Integer> quadruplet = new ArrayList<Integer>(Arrays.asList(nums[x], nums[i], nums[j], nums[k]));
                        resultSet.add(quadruplet);
                        j++;
                    } else if (currentSum.longValue() < targetCopy.longValue()) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        for (List<Integer> quadruplet : resultSet) {
            result.add(quadruplet);
        }
        return result;
    }
}