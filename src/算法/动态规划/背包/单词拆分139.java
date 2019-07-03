package 算法.动态规划.背包;

import java.util.HashSet;
import java.util.List;

public class 单词拆分139 {
    //下面这个思路清晰.
    //i为从头开始子串的长度,j为拆分位置,对于每一个i拆分的子串dp[j]和substring(j,i),分别判断是否能够满足拆分即可,不能满足则更换位置,还不行则移动i.
    //https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/最后动归方法.
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];   //dp[i]代表的是,字符串的前i个字符(0~i-1)是否能被成功拆分.
            dp[0] = true;
            HashSet<String> set = new HashSet<>(wordDict);  //建立字典集,后面判断可以用contains方法
            for(int i = 1; i <= s.length(); i++){
                //i指两方面,对于dp是前i个字符.对于划分的字符串,前i个字符的最后一个索引为i-1,
                //所以substring后面的参数为i,(不包含).拆分是一共i个字符,分成前j个,和后i-j个.前面的还是dp[j],后面的可以用字典集是否包含来解决.
                for(int j = 0; j < i; j++){  //目的是判断dp[i],找到就可以break;
                    if (dp[j] && set.contains(s.substring(j, i))){  //循环直到找到满足
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        for (int i = 1; i <= n; i++) {
//            for (String ss : wordDict) {
//                int len = ss.length();
//                if (i >= len && ss.equals(s.substring(i - len, i))) {  //左边是>=
//                    dp[i] = dp[i] || dp[i - len];  //右边是i-len
//                }
//            }
//        }
//        return dp[n];
//    }
}
