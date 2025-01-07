class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int start = 0; start < s.length(); start++) {
            String oddString = checkResursively(s, start, start);
            if (oddString.length() > result.length()) {
                result = oddString;
            }
            int end = start + 1;
            if (end < s.length() && s.charAt(start) == s.charAt(end)) {
                String evenString = checkResursively(s, start, end);
                if (evenString.length() > result.length()) {
                    result = evenString;
                }
            }
        }
        return result;
    }

    public String checkResursively(String s, int start, int end) {
        int newStart = start - 1;
        int newEnd = end + 1;
        if (newStart < 0 || newEnd == s.length()) {
            return s.substring(start, end + 1);
        } else {
            if (s.charAt(newStart) == s.charAt(newEnd)) {
                return checkResursively(s, newStart, newEnd);
            } else {
                return s.substring(start, end + 1);
            }
        }
    }
}