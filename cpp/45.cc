class Solution {
    public:
        int jump(vector<int>& nums) {
            vector<int> jump_count = vector<int>(nums.size(), nums.size());
            jump_count[0] = 0;
            for (int i = 0; i < nums.size(); i++) {
                for (int j = 1; j <= nums[i] && i + j < nums.size(); j++) {
                    int new_position = i + j;
                    if (jump_count[i] + 1 < jump_count[new_position]) {
                        jump_count[new_position] = jump_count[i] + 1;
                    }
                }
            }
            return jump_count[jump_count.size() - 1];
        }
    };
    