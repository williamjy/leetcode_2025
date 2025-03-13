class Solution {
    public int maximumSwap(int num) {
        int[] numArray = new int[9];
        int[] maxDigits = new int[9];
        int numCopy = num;
        int length = String.valueOf(num).length();
        for (int i = 0; i < length; i++) {
            int digit = numCopy % 10;
            numArray[8 - i] = digit;
            for (int j = 9 - length; j < 9 - i; j++) {
                if (maxDigits[j] < digit) {
                    maxDigits[j] = digit;
                }
            }
            numCopy /= 10;
        }
        int left = -1;
        for (int i = 9 - length; i < 9; i++) {
            if (left == -1) {
                if (numArray[i] < maxDigits[i]) {
                    left = i;
                    break;
                }
            }
        }
        if (left >= 0 && left < 8) {
            for (int i = 8; i >= left + 1; i--) {
                if (numArray[i] == maxDigits[left + 1]) {
                    int tmp = numArray[i];
                    numArray[i] = numArray[left];
                    numArray[left] = tmp;
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 9 - length; i < 9; i++) {
            result *= 10;
            result += numArray[i];
        }
        return result;
    }
}