class Solution {
    public:
        int numDecodings(string s) {
            if (s[0] == '0') {
                return 0;
            }
            if (s.size() == 1) {
                return 1;
            }
            vector<int> dp(s.length(), 0);
            dp[0] = 1;
            if (s[0] == '1' || (s[0] == '2' && s[1] >= '0' && s[1] <= '6')) {
                dp[1]++;
            }
            if (s[1] != '0') {
                dp[1]++;
            }
            for (int i = 2; i < s.length(); i++) {
                if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '0' && s[i] <= '6')) {
                    dp[i] += dp[i - 2];
                }
                if (s[i] != '0') {
                    dp[i] += dp[i - 1];
                }
            }
            return dp[s.length() - 1];
        }
    };