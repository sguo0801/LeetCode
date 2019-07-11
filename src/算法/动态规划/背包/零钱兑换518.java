package 算法.动态规划.背包;

public class 零钱兑换518 {
    public int change(int amount, int[] coins) {
        //带边界条件就不对.不知道为什么
        int[] dp = new int[amount + 1];
        dp[0] = 1;  //注意初始值为1.凑0就是什么都不添加
        for (int a : coins) {
            for (int i = a; i <= amount; i++) {
                dp[i] += dp[i - a];
            }
        }
        return dp[amount];
    }
}
