class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchRecursively(s, p, 0, 0);
    }

    public boolean isMatchRecursively(String s, String p, Integer stringIndex, Integer patternIndex) {
        if (stringIndex >= s.length() && patternIndex >= p.length()) {
            return true;
        }
        if (patternIndex >= p.length()) {
            return false;
        }
        boolean result = false;

        if (patternIndex + 1 < p.length() && p.charAt(patternIndex + 1) == '*') {
            char patternCharacter = p.charAt(patternIndex);
            result |= isMatchRecursively(s, p, stringIndex, patternIndex + 2);
            for (int index = stringIndex; index < s.length() && (patternCharacter == '.' || s.charAt(index) == patternCharacter); index++) {
                result |= isMatchRecursively(s, p, index + 1, patternIndex + 2);
            }
        } else {
            if (stringIndex < s.length() && (p.charAt(patternIndex) == '.' || s.charAt(stringIndex) == p.charAt(patternIndex))) {
                 result |= isMatchRecursively(s, p, stringIndex + 1, patternIndex + 1);
            }
        }
        return result;
    }
}