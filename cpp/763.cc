class Solution {
    public:
        vector<int> partitionLabels(string s) {
            vector<int> result;
            map<char, int> char_map;
            for (char c : s) {
                char_map[c]++;
            }
            map<char, bool> char_visited;
            int start = 0;
            int count = 0;
            for (int end = 0; end < s.size(); end++) {
                char c = s[end];
                if (char_map.count(c) > 0 && char_visited[c] == false) {
                    char_visited[c] = true;
                    count++;
                }
                char_map[c]--;
                if (char_map[c] == 0) {
                    count--;
                    if (count == 0) {
                        result.push_back(end - start + 1);
                        start = end + 1;
                    }
                }
            }
            return result;
        }
    };