package 动态规划;

public class 最长公共子序列 {
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];  //有个前0个,所以+1.dp[i][j] 表示 S1 的前 i 个字符与 S2 的前 j 个字符最长公共子序列的长度.(指的是0~i-1或j-1的字符)
        for (int i = 1; i <= n1; i++) {  //dp[0][0]自然初始为0.
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1; //看第i,和第j个字符(i-1,j-1)是否相同.则可以判断前i和j的dp[i][j]
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n1][n2];
    }
}
