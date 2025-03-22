class Solution {
    public:
        int findDuplicate(vector<int>& nums) {
            for (int i = 0; i < nums.size(); i++) {
                int numToCheck = abs(nums[i]);
                    nums[numToCheck - 1] = - nums[numToCheck - 1];
                    if (nums[numToCheck - 1] > 0) {
                        return numToCheck;
                    }            
            }
            return 0;
        }
    };