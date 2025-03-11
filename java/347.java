class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (numsCount.containsKey(num)) {
                numsCount.put(num, numsCount.get(num) + 1);
            } else {
                numsCount.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numsCount.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(list.size() - 1 - i).getKey();
        }
        return result;
    }
}