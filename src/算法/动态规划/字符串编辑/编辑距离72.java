package 算法.动态规划.字符串编辑;
//这就是动态规划的魅力吧,不需要知道怎么转的,删还是换还是增,从头开始盘!!
public class 编辑距离72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];  //意义是把word1的前i个字符转换成word2的前j个字符的最少操作数
        dp[0][0] = 0;//默认为0,可以不写
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;//相当于一个是null,一个是i长的字符串,所以操作为删掉i次
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;  //两个边界m,n不同,所以分开赋值.
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  //相当于不需要增加操作,即相同
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;//不需要管怎么转换的,记得操作数即可.都是从最开始就转啦.
                }
            }
        }
        return dp[m][n];

    }
}
