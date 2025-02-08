class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMapCalculation = new HashMap<Character, Integer>();
        int total = t.length(), counter = 0;
        for (Character c : t.toCharArray()) {
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }
        if (tMap.containsKey(s.charAt(0))) {
            tMapCalculation.put(s.charAt(0), 1);
            counter++;
        }
        int left = 0, right = 0;
        String result = "";
        while (left < s.length() && right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (counter == total) {
                while (left <= right && counter == total) {
                    leftChar = s.charAt(left);
                    String newResult = s.substring(left, right + 1);
                    if (newResult.length() <= result.length() || result == "") {
                        result = newResult;
                    }
                    if (tMapCalculation.containsKey(leftChar) && tMapCalculation.get(leftChar) > 0) {
                        tMapCalculation.put(leftChar, tMapCalculation.get(leftChar) - 1);
                        if (tMap.get(leftChar) > tMapCalculation.get(leftChar)) {
                            counter--;
                        }
                    }
                    left++;
                }
            } else {
                right++;
                if (right == s.length()) {
                    break;
                }
                rightChar = s.charAt(right);
                if (tMap.containsKey(rightChar)) {
                    if (tMapCalculation.containsKey(rightChar) && tMapCalculation.get(rightChar) > 0) {
                        tMapCalculation.put(rightChar, tMapCalculation.get(rightChar) + 1);
                    } else {
                        tMapCalculation.put(rightChar, 1);
                    }
                    if (tMap.get(rightChar) >= tMapCalculation.get(rightChar)) {
                        counter++;
                    }
                }
            }
        }
        return result;
    }
}