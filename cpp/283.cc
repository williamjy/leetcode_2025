class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        if (nums.size() == 0) {
            return;
        }
        int left = 0;
        while (left < nums.size() && nums[left] != 0) {
            left++;
        }
        int right = left;
        while (right < nums.size() && nums[right] == 0) {
            right++;
        }
        while (right < nums.size() && left < right) {
            // int tmp = nums[left];
            // nums[left] = nums[right];
            // nums[right] = tmp;
            swap(nums[left], nums[right]);
            while (left < nums.size() && nums[left] != 0) {
                left++;
            }
            right = left;
            while (right < nums.size() && nums[right] == 0) {
                right++;
            }
        }
        return;
    }
};