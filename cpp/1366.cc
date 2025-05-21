struct vector_cmp {
    bool operator() (const vector<int>& left, const vector<int>& right) const {
        for (int i = 0; i < 26; i++) {
            if (left[i] > right[i]) {
                return true;
            } else if (left [i] < right[i]) {
                return false;
            }
        }
        return left[26] < right[26];
    }
};

class Solution {
public:
    string rankTeams(vector<string>& votes) {
        vector<vector<int>> char_counts(26, vector<int>(27, 0));
        for (int i = 0; i < 26; i++) {
            char_counts[i][26] = i + 'A';
        }
        for (int i = 0; i < votes[0].size(); i++) {
            for (auto vote : votes) {
                char_counts[vote[i] - 'A'][i]++;
            }
        }
        sort(char_counts.begin(), char_counts.end(), vector_cmp());
        string result = "";
        for (int i = 0; i < votes[0].size(); i++) {
            result += char_counts[i][26];
        }
        return result;
    }
};