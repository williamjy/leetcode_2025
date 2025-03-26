class Solution {
    public:
        int countSubstrings(string s) {
            int result = 0;
            for (int mid = 0; mid < s.size(); mid++) {
                for (int left = mid, right = mid; left >= 0 && right < s.size(); left--, right++) {
                    if (s[left] != s[right]) {
                        break;
                    }
                    result++;
                }
            }
            for (int mid = 0; mid < s.size(); mid++) {
                for (int left = mid, right = mid + 1; left >= 0 && right < s.size(); left--, right++) {
                    if (s[left] != s[right]) {
                        break;
                    }
                    result++;
                }
            }
            return result;
        }
    };