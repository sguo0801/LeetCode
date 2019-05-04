package 动态规划.背包;
//背包问题都要重新看!!!!!!
//该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
//可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
//                  sum(P) - sum(N) = target
//sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                       2 * sum(P) = target + sum(nums)
//Copy to clipboardErrorCopied
//因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
public class 目标和494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if (sum < S || ((sum + S) & 1) == 1) {
            return 0;
        }
        int W = (sum + S) >> 1;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int a : nums) {
            for (int i = W; i >= a; i--) {
                dp[i] = dp[i] + dp[i - a];  //dp[i]初始为0,这边是循环遍历更新方法数.
            }
        }
        return dp[W];
    }
}
