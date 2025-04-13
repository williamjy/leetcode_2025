class Solution {
    public:
        int minDistance(string word1, string word2) {
            vector<vector<int>> dp(word1.size() + 1, vector<int>(word2.size() + 1, 1000));
            for (int i = 0; i <= word1.size(); i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= word2.size(); i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= word1.size(); i++) {
                for (int j = 1; j <= word2.size(); j++) {
                    int insertion = dp[i - 1][j] + 1;
                    int deletion = dp[i][j - 1] + 1;
                    int replace = 0;
                    if (word1[i - 1] == word2[j - 1]) {
                        replace = dp[i - 1][j - 1];
                    } else {
                        replace = dp[i - 1][j - 1] + 1;
                    }
                    dp[i][j] = min(insertion, deletion);
                    dp[i][j] = min(dp[i][j], replace);
                }
            }
            return dp[word1.size()][word2.size()];
        }
    };