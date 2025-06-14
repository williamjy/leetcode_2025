class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        int i = 0, j = 0;
        map<int, int> num_count;
        for (;j < nums.size();) {
            if (j - i <= k) {
                num_count[nums[j]]++;
                if (num_count[nums[j]] == 2) {
                    return true;
                }
                j++;
            } else {
                num_count[nums[i]]--;
                i++;
            }
        }
        return false;
    }
};