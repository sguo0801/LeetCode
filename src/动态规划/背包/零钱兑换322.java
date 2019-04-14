package 动态规划;
//硬币可以重复使用，因此这是一个完全背包问题。完全背包只需要将 0-1 背包中逆序遍历 dp 数组改为正序遍历即可。逆序是源头中代码的.
//public int coinChange(int[] coins, int amount) {
//    if (amount == 0 || coins == null || coins.length == 0) {
//        return 0;
//    }
//    int[] dp = new int[amount + 1];
//    for (int coin : coins) {
//        for (int i = coin; i <= amount; i++) { //将逆序遍历改为正序遍历
//            if (i == coin) {
//                dp[i] = 1;
//            } else if (dp[i] == 0 && dp[i - coin] != 0) {
//                dp[i] = dp[i - coin] + 1;
//            } else if (dp[i - coin] != 0) {
//                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//            }
//        }
//    }
//    return dp[amount] == 0 ? -1 : dp[amount];
//}
public class 零钱兑换322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1]; //达成该金额的最小硬币数目
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && dp[i] > dp[i - coins[j]] + 1 && dp[i - coins[j]] != Integer.MAX_VALUE) {  //注意i>=coins[j]中有=.
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
