class Solution {
    public boolean isPalindrome(String s) {
        String trimmedS = "";
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if ((currChar >= 'a' && currChar <= 'z') || (currChar >= 'A' && currChar <= 'Z') || (currChar >= '0' && currChar <= '9')) {
                trimmedS += s.substring(i, i + 1);
            }
        }
        trimmedS = trimmedS.toLowerCase();
        for (int i = 0; i < trimmedS.length() / 2; i++) {
            if (trimmedS.charAt(i) != trimmedS.charAt(trimmedS.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}