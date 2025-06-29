// Time Complexity : O(m*n) - m is number of coins and n is amount
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            dp[j] = 99999;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }

        if (dp[n] == 99999) return -1;
        return dp[n];
    }
}
