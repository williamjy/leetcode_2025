class Solution {
    public:
        int rob(vector<int>& nums) {
            if (nums.size() == 1) {
                return nums[0];
            }
            if (nums.size() == 2) {
                return max(nums[0], nums[1]);
            }
            vector<int> max_amount_rob_first(nums.size(), 0);
            max_amount_rob_first[0] = nums[0];
            max_amount_rob_first[1] = nums[0];
            for (int i = 2; i < max_amount_rob_first.size() - 1; i++) {
                max_amount_rob_first[i] = max(max_amount_rob_first[i - 2] + nums[i], max_amount_rob_first[i - 1]);
            }
            vector<int> max_amount_not_rob_first(nums.size(), 0);
            max_amount_not_rob_first[0] = 0;
            max_amount_not_rob_first[1] = nums[1];
            for (int i = 2; i < max_amount_not_rob_first.size(); i++) {
                max_amount_not_rob_first[i] = max(max_amount_not_rob_first[i - 2] + nums[i], max_amount_not_rob_first[i - 1]);
            }
            int max_amount = 0;
            max_amount = max(max_amount_rob_first[max_amount_rob_first.size() - 2], max_amount_rob_first[max_amount_not_rob_first.size() - 2]);
            max_amount = max(max_amount, max_amount_not_rob_first[max_amount_not_rob_first.size() - 1]);
            return max_amount;
        }
    };