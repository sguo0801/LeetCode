package 算法.动态规划.背包;
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
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                dp[i] = Integer.MAX_VALUE;
                for(int j = 0; j < coins.length; j++){
                    if(coins[j] <= i && dp[i - coins[j]] !=  Integer.MAX_VALUE){   //去掉右侧为最大值的情况.否则如果只有2硬币,要求配出3,会使得dp[3]为max+1.且又不为max.
                        // 所以要么这里规避最大值的情况.要么最后返回的时候控制好结果范围,使这种情况也可以返回-1.
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE  ? -1 : dp[amount];
        }
    }
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0 || coins == null || coins.length == 0) {
//            return 0;
//        }
//        int n = coins.length;
//        int[] dp = new int[amount + 1]; //达成该金额的最小硬币数目
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            dp[i] = Integer.MAX_VALUE;  //初始要为最大值,这样后面可以取min(dp[i], dp[i-coin]+1),通过循环比较每一个小于i的coin的硬币情况.
//            for (int j = 0; j < n; j++) {
//                if (i >= coins[j] && dp[i] > dp[i - coins[j]] + 1 && dp[i - coins[j]] != Integer.MAX_VALUE) {  //注意i>=coins[j]中有=.
//                    dp[i] = dp[i - coins[j]] + 1;
//                }
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//    }

}
