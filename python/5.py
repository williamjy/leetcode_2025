class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == "":
            return ""
        dp = [[0] * len(s) for _ in range(len(s))]
        longest_str = s[0]
        for i in range(len(s)):
            dp[i][i] = 1
        for i in range(len(s) - 1):
            if s[i] == s[i + 1]:
                dp[i][i + 1] = 1
                if (len(longest_str) < len(s[i : i + 2])):
                    longest_str = s[i : i + 2]
        for diff in range(2, len(s)):
            for i in range(0, len(s) - diff):
                j = i + diff
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1]
                if dp[i][j] == 1:
                    if (len(longest_str) < len(s[i : j + 1])):
                        longest_str = s[i : j + 1]
        return longest_str
