class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int size = rowLength * columnLength;
        int i = 0, j = size - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int row = mid / columnLength;
            int column = mid % columnLength;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}