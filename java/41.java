class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        sortedMap.put(0, 0);
        for (Integer num : nums) {
            if (!visited.containsKey(num)) {
                visited.put(num, true);
                if (num >= 0 && !sortedMap.containsKey(num)) {
                    if (sortedMap.containsKey(num + 1)) {
                        int value = sortedMap.get(num + 1);
                        sortedMap.remove(num + 1);
                        sortedMap.put(num, value);
                    } else {
                        sortedMap.put(num, num);
                    }
                }
            }
        }
        for (Integer start : sortedMap.keySet()) {
            Integer end = sortedMap.get(start);
            if (!sortedMap.containsKey(end + 1)) {
                return end + 1;
            }
        }
        return 0;
    }
}