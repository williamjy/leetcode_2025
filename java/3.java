class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while (end < s.length()) {
            if (letterMap.containsKey(s.charAt(end))) {
                int duplicateEnd = letterMap.get(s.charAt(end));
                Iterator<Map.Entry<Character, Integer>> iterator = letterMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Character, Integer> entry = iterator.next();
                    if (entry.getValue() <= duplicateEnd) {
                        iterator.remove();
                    }
                }
                letterMap.put(s.charAt(end), end);
                start = duplicateEnd + 1;
                end++;
            } else {
                letterMap.put(s.charAt(end), end);
                int newLength = end - start + 1;
                if (newLength > maxLength) {
                    maxLength = newLength;
                }
                end++;
            }
        }
        return maxLength;
    }
}