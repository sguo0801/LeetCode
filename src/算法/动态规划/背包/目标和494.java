package 算法.动态规划.背包;
//思想：在某个解中正数和为x，负数和的绝对值为y，则x+y=sum，x-y=S，解得x=(sum+S)/2
//所以就有在nums中选择一部分数（装与不装到背包中），让其和为x（总的容量为x），此时转化为了0-1背包问题, 剩余部分数据和当然为y，所以x+y=sum，x-y=S（y中的数都去负号）
//
//同时可有sum+S为奇数，则一定没有解的推论，因为要除以2才是x的解
//
//此时dp数组中保存前i个数字能得到容量为j的结果的总数
//
//注意：special case：
// 当某个值为0时，在背包中是不允许的，因为如果有0会出现很多例外情况要单独处理，所以我代码会把0先弄出来处理掉，
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
        int[] dp = new int[W + 1];   //找到W个1,为正好即可
        dp[0] = 1;   //就是说想要和为0的时候有一种情况,就是都不选.
        for (int a : nums) {
            for (int i = W; i >= a; i--) {
                dp[i] = dp[i] + dp[i - a];  //dp[i]初始为0,这边是循环遍历更新方法数.
            }
        }
        return dp[W];
    }
}
