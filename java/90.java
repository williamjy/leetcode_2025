class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        createRecursively(nums, resultSet, subset, 0);
        result.addAll(resultSet);
        return result;
    }

    public void createRecursively(int[] nums, Set<List<Integer>> resultSet, List<Integer> subset, int index) {
        if (index == nums.length) {
            List<Integer> subsetDeepCopy = new ArrayList<Integer>(subset);
            resultSet.add(subsetDeepCopy);
            return;
        }
        createRecursively(nums, resultSet, subset, index + 1);
        subset.add(nums[index]);
        createRecursively(nums, resultSet, subset, index + 1);
        subset.remove(subset.size() - 1);
        return;
    }
}