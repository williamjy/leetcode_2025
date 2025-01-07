class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate_recursively(result, "", n, n);
        return result;
    }

    public void generate_recursively(List<String> result, String currentString, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(currentString);
            return;
        }
        if (left == right) {
            currentString += "(";
            generate_recursively(result, currentString, left - 1, right);
            currentString = currentString.substring(0, currentString.length() - 1);
        } else if (left == 0) {
            currentString += ")";
            generate_recursively(result, currentString, left, right - 1);
            currentString = currentString.substring(0, currentString.length() - 1);
        } else {
            currentString += "(";
            generate_recursively(result, currentString, left - 1, right);
            currentString = currentString.substring(0, currentString.length() - 1);

            currentString += ")";
            generate_recursively(result, currentString, left, right - 1);
            currentString = currentString.substring(0, currentString.length() - 1);
        }
        return;
    }
}