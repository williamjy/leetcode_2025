class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> result;
        if (s.size() < 10) {
            return result;
        }
        int right = 9;
        map<string, int> sequence_map;
        for (; right < s.size(); right++) {
            string sequence = s.substr(right - 9, 10);
            sequence_map[sequence]++;
        }
        for (auto it : sequence_map) {
            if (it.second > 1) {
                result.push_back(it.first);
            }
        }
        return result;
    }
};