class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String result = "";
        int length = s.length();
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1) {
                for (int index = 0 + row; index < length; index += (numRows - 1) * 2) {
                    result += s.charAt(index);
                }
            } else {
                boolean isOnStraightLine = true;
                for (int index = 0 + row; index < length;) {
                    result += s.charAt(index);
                    if (isOnStraightLine) {
                        index += (numRows - row - 1) * 2;
                    } else {
                        index += row * 2;
                    }
                    isOnStraightLine = !isOnStraightLine;
                }
            }
        }
        return result;
    }
}