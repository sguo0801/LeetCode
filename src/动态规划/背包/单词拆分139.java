package 动态规划;

import java.util.List;

public class 单词拆分139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String ss : wordDict) {
                int len = ss.length();
                if (i >= len && ss.equals(s.substring(i - len, i))) {  //左边是>=
                    dp[i] = dp[i] || dp[i - len];  //右边是i-len
                }
            }
        }
        return dp[n];
    }
}
