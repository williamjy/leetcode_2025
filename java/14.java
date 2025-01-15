class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        for (int i = 0;;i++) {
            boolean breakLoop = false;
            if (i >= strs[0].length()) {
                break;
            }
            char commonChar = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                String currentString = strs[j];
                if (i >= strs[j].length() || commonChar != strs[j].charAt(i)) {
                    breakLoop = true;
                    break;
                }
            }
            if (breakLoop) {
                break;
            }
            commonPrefix += commonChar;
        }
        return commonPrefix;
    }
}