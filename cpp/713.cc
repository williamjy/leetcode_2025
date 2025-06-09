class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int i = 0, j = 0;
        int product = 1;
        int result = 0;
        for (; i < nums.size(); i++) {
            product *= nums[i];
            // int curr_product = product;
            for (; j <= i && product >= k; j++) {
                product /= nums[j];
            }
            result += (i - j + 1);
        }
        return result;
    }
};