class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        map<char, int> char_map;
        int max_length = 0;
        for (int i = 0, j = 0; j < s.size();) {
            char_map[s[j]]++;
            if (char_map.size() <= 2) {
                max_length = max(max_length, j - i + 1);
            } else {
                while (char_map.size() > 2 && i < s.size()) {
                    char_map[s[i]]--;
                    if (char_map[s[i]] <= 0) {
                        char_map.erase(s[i]);
                    }
                    i++;
                }
                max_length = max(max_length, j - i + 1);
            }
            j++;
        }
        return max_length;
    }
};