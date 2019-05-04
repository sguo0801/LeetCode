package 算法.动态规划.字符串编辑;
//就是求两个字符串的最长公共子序列长度,
public class 字符串删除操作583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {  //可以=m,n
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  //是转换成求最长公共子序列
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
