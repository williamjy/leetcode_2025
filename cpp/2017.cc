class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        vector<long long> first_row(grid[0].size(), 0);
        vector<long long> second_row(grid[0].size(), 0);
        first_row[grid[0].size() - 1] = grid[0][grid[0].size() - 1];
        second_row[0] = grid[1][0];
        for (int i = grid[0].size() - 2; i >= 0; i--) {
            first_row[i] = grid[0][i] + first_row[i + 1];
        }
        for (int i = 1; i < grid[0].size(); i++) {
            second_row[i] = grid[1][i] + second_row[i - 1];
        }
        long long min_value = LLONG_MAX;
        for (int i = 0; i < grid[0].size(); i++) {
            long long left_side = 0;
            if (i > 0) {
                left_side = second_row[i - 1];
            }
            long long right_side = 0;
            if (i < grid[0].size() - 1) {
                right_side = first_row[i + 1];
            }
            long long curr_min = max(left_side, right_side);
            if (curr_min < min_value) {
                min_value = curr_min;
            }
        }
        return min_value;
    }
};