class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> outputMap = new HashMap<String,List<String>>();
        for (String str : strs) {
            String sortedString = sortString(str);
            if (outputMap.containsKey(sortedString)) {
                List<String> anagrams = outputMap.get(sortedString);
                anagrams.add(str);
            } else {
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(str);
                outputMap.put(sortedString, anagrams);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String sortedString : outputMap.keySet()) {
            List<String> anagrams = outputMap.get(sortedString);
            result.add(anagrams);
        }
        return result;
    }

    public String sortString(String str) {
        char tempArray[] = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}