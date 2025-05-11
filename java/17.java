class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.equals("")) {
            return result;
        }
        String current = "";
        getCombination(digits, result, current, 0);
        return result;
    }

    void getCombination(String digits, List<String> result, String current, int position) {
        if (position == digits.length()) {
            result.add(current);
            return;
        }
        if (digits.charAt(position) == '2') {
            current += 'a';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'b';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'c';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '3') {
            current += 'd';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'e';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'f';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '4') {
            current += 'g';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'h';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'i';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '5') {
            current += 'j';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'k';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'l';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '6') {
            current += 'm';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'n';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'o';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '7') {
            current += 'p';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'q';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'r';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 's';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '8') {
            current += 't';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'u';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'v';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        } else if (digits.charAt(position) == '9') {
            current += 'w';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'x';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'y';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
            current += 'z';
            getCombination(digits, result, current, position + 1);
            current = current.substring(0, current.length() - 1);
        }
    }
}