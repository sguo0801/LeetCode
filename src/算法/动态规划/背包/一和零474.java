package 算法.动态规划.背包;
//不会!!!!!
public class 一和零474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0) {
                return 0;
            }
            int[][] dp = new int[m + 1][n + 1];
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
                    }
                }
            }
            return dp[m][n];
        }
    }
}
