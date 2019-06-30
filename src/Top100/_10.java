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
    //                2如果p.charAt（j-1）== s.charAt（i）或p.charAt（j-1）=='。'：
    //                               dp [i] [j] = dp [i-1] [j] //在这种情况下，a *计为多个a
    //                            或dp [i] [j] = dp [i] [j-1] //在这种情况下，a *计为单个a
    //                            或者dp [i] [j] = dp [i] [j-2] //在这种情况下，a *计为空
//    class Solution {
//        public boolean isMatch(String s, String p) {
//
//            if (s == null || p == null) {
//                return false;
//            }
//            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//            dp[0][0] = true;
//
//            //??
//            for (int i = 0; i < p.length(); i++) {
//                if (p.charAt(i) == '*' && dp[0][i - 1]) {
//                    dp[0][i + 1] = true;
//                }
//            }
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = 0; j < p.length(); j++) {
//                    if (p.charAt(j) == '.') {
//                        dp[i + 1][j + 1] = dp[i][j];
//                    }
//                    if (p.charAt(j) == s.charAt(i)) {
//                        dp[i + 1][j + 1] = dp[i][j];
//                    }
//                    if (p.charAt(j) == '*') {
//                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
//                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
//                        } else {
//                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
//                        }
//                    }
//                }
//            }
//            return dp[s.length()][p.length()];
//        }
//    }
    //r[i][j] means to index i of s and index j of p, whether it match or not.
    //if(pc[j - 1] == "*") r[0][j] = r[0][j - 2] why j - 2 here, means * cannot work alone.
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            char[] cs = s.toCharArray();
            char[] cp = p.toCharArray();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            //如果p开始是a*要去掉.// *可以消掉c*
            for (int i = 2; i <= n; i++) {
                if (cp[i - 1] == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    if (cp[j - 1] == '*') {
                        if (cs[i - 1] != cp[j - 2] && cp[j - 2] != '.') {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                            // 当*的前一位是'.'， 或者前一位的pc等于sc的话，
                            // *代表1个(dp[i][j - 1])，*代表多个(dp[i - 1][j])，或者用*消掉c*(dp[i][j - 2])
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
