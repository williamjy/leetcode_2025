public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed_n = 0;
        for (int i = 0; i < 32; i++) {
            int ith_bit = 1 << i;
            ith_bit = ith_bit & n;
            if (ith_bit != 0) {
                reversed_n |= 1 << (31 - i);
            }
        }
        return reversed_n;
    }
}