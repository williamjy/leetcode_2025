class Solution {
    public:
        int rob(vector<int>& nums) {
            if (nums.size() == 1) {
                return nums[0];
            }
            vector<int> result(nums.size(), 0);
            result[0] = nums[0];
            result[1] = max(nums[0], nums[1]);
            for (int i = 2; i < nums.size(); i++) {
                result[i] = max(result[i - 2] + nums[i], result[i - 1]);
            }
            return max(result[result.size() - 2], result[result.size() - 1]);
        }
    };