package 算法.动态规划.背包;
//本题主要两点：
//
//物品（数组中的字符串）；背包限制（0,1数量）
//因为背包有两个限制，所以是二维背包，需要通过二维数组进行实现。 即：dp[i][j]=max(dp[i][j],dp[i-0数量][j-1数量]+1)；表示[0:i-1]的字符串物品中，j个0，k个1最多能够构成字符串数量。
//题中是用dp[i][j]
public class 一和零474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0) {
                return 0;
            }
            int[][] dp = new int[m + 1][n + 1];
            //统计该串0.1的个数
            for (String s : strs) {
                int zero = 0;
                int one = 0;  //每个字符串后面直接使用
                for (char c : s.toCharArray()) {
                    if (c == '0') {
                        zero++;
                    } else {
                        one++;
                    }
                }

                for (int i = m; i >= zero; i--) {
                    for (int j = n; j >= one; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);//i-zero,j-one,指的是到当前字符串的前,所能消耗的0.1个数.
                        //通俗一点就是现在可以不要这个字符串(不可能是这个,为0),可以要这个字符串,然后去掉所用的,看剩下的能满足几个串,剩下的就是dp[i - zero][j - one].i,j逐渐减小的过程中,可以有最大的dp[i][j]
                    }
                }
            }
            return dp[m][n];
        }
    }
}
