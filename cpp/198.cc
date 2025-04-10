class Solution {
    public:
        int rob(vector<int>& nums) {
            if (nums.size() == 1) {
                return nums[0];
            }
            if (nums.size() == 2) {
                return max(nums[0], nums[1]);
            }
            if (nums.size() == 2) {
                return max(nums[0] + nums[2], nums[1]);
            }
            vector<int> result(nums.size(), 0);
            result[0] = nums[0];
            result[1] = nums[1];
            result[2] = nums[0] + nums[2];
            for (int i = 3; i < nums.size(); i++) {
                result[i] = max(result[i - 2] + nums[i], result[i - 1]);
                result[i] = max(result[i - 3] + nums[i], result[i]);
            }
            return max(result[result.size() - 2], result[result.size() - 1]);
        }
    };