class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] rowCounter = new boolean[row];
        boolean[] columnCounter = new boolean[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowCounter[i] = true;
                    columnCounter[j] = true;
                }
            }
        }
        for (int i = 0; i < rowCounter.length; i++) {
            if (rowCounter[i]) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < columnCounter.length; j++) {
            if (columnCounter[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}