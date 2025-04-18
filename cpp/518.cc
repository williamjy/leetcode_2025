class Solution {
    public:
        int change(int amount, vector<int>& coins) {
            sort(coins.begin(), coins.end(), std::greater<int>());
            vector<vector<int>> dp(amount + 1, vector<int>(coins.size(), 0));
            for (int i = 0; i <= amount / coins[0]; i++) {
                dp[i * coins[0]][0] = 1;
            }
            for (int coin_index = 1; coin_index < coins.size(); coin_index++) {
                for (int value = 0; value <= amount; value++) {
                    for (int j = 0; j <= value / coins[coin_index]; j++) {
                        if (INT_MAX - dp[value][coin_index] >= dp[value - j * coins[coin_index]][coin_index - 1]) {
                            dp[value][coin_index] += dp[value - j * coins[coin_index]][coin_index - 1];
                        } else {
                            return 0;
                        }
                    }
                }
            }
            return dp[amount][coins.size() - 1];
        }
    };