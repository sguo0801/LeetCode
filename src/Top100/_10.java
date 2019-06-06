package Top100;

//正则表达式
public class _10 {
    //2D DP。 击败90％的解决方案，非常简单。
    //
    //这里有一些要弄清楚的条件，那么逻辑可以非常简单。
    //
    //1，如果p.charAt（j）== s.charAt（i）：dp [i] [j] = dp [i-1] [j-1];
    //2，如果p.charAt（j）=='。' ：dp [i] [j] = dp [i-1] [j-1];
    //3，如果p.charAt（j）=='*'：
    //    这里有两个子条件：
    //                1如果p.charAt（j-1）！= s.charAt（i）：dp [i] [j] = dp [i] [j-2] //在这种情况下，a *仅计为空
    //                2如果p.charAt（i-1）== s.charAt（i）或p.charAt（i-1）=='。'：
    //                               dp [i] [j] = dp [i-1] [j] //在这种情况下，a *计为多个a
    //                            或dp [i] [j] = dp [i] [j-1] //在这种情况下，a *计为单个a
    //                            或者dp [i] [j] = dp [i] [j-2] //在这种情况下，a *计为空
    class Solution {
        public boolean isMatch(String s, String p) {

            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
