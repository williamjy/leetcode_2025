class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (y > x) {
            return getSum(b, a);
        }
        int sign = (a > 0) ? 1 : -1;
        if (a * b >= 0) {
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            while (y != 0) {
                int answer = x ^ y;
                int carry = ((~x) & y) << 1;
                x = answer;
                y = carry;
            }
        }
        return x * sign;
    }
}