class Solution {
    public:
        bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
            vector<bool> is_possible(3, false);
            for (int i = 0; i < triplets.size(); i++) {
                if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                    is_possible[0] = true;
                }
                if (triplets[i][0] <= target[0] && triplets[i][1] == target[1] && triplets[i][2] <= target[2]) {
                    is_possible[1] = true;
                }
                if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] == target[2]) {
                    is_possible[2] = true;
                }
            }
            return is_possible[0] && is_possible[1] && is_possible[2];
        }
    };