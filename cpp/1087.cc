class Solution {
private:
    string curr = "";
    vector<string> result;
public:
    vector<string> expand(string s) {
        expandRecursively(s, 0);
        return result;
    }
    void expandRecursively(string s, int position) {
        if (position >= s.size()) {
            result.push_back(curr);
            return;
        }
        if (s[position] == '{') {
            int new_position = position;
            while (s[new_position++] != '}') {
            }
            string sub_s = s.substr(position + 1, new_position - 2 - position);
            sort(sub_s.begin(), sub_s.end());
            for (int j = 0; j < sub_s.size(); j++) {
                if (sub_s[j] == ',') {
                    continue;
                }
                curr += sub_s[j];
                expandRecursively(s, new_position);
                curr.pop_back();
            }
        } else {
            curr += s[position];
            expandRecursively(s, position + 1);
            curr.pop_back();
        }
    }
};