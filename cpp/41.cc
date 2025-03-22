class Solution {
    public:
        int firstMissingPositive(vector<int>& nums) {
            int length = nums.size();
            bool isOneExist = false;
            for (int i = 0; i < length; i++) {
                if (nums[i] == 1) {
                    isOneExist = true;
                } else if (nums[i] < 1 || nums[i] > length) {
                    nums[i] = 1;
                }
            }
            if (isOneExist == false) {
                return 1;
            }
            for (int i = 0; i < length; i++) {
                if (abs(nums[i]) > 1) {
                    int num = abs(nums[i]);
                    nums[num - 1] = -abs(nums[num - 1]);
                }
            }
            for (int i = 1; i < length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return length + 1;
        }
    };