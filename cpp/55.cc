class Solution {
    public:
        bool canJump(vector<int>& nums) {
            vector<bool> nums_bool = vector<bool>(nums.size(), false);
            nums_bool[0] = true;
            for (int i = 0; i < nums.size(); i++) {
                if (nums_bool[i] == true) {
                    for (int j = 1; j <= nums[i] && i + j < nums_bool.size(); j++) {
                        nums_bool[i + j] = nums_bool[i];
                    }
                }
            }
            return nums_bool[nums_bool.size() - 1];
        }
    };
    