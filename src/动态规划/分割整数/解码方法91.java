package 动态规划;
//此方法可以避免考虑初始字符为0的情况.简单好理解,本体其实是f(n)=f(n-1)+f(n-2)的变形,只不过要判断,是否进行相加,一位数排除0的情况,两位数就在10~26之间.
public class 解码方法91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[n + 1];
        dp[0] = 1; //主要是为了后面计算dp[i] += dp[i-1]的初始值.
        for (int i = 1; i <= n; i++) {
            int t = ch[i - 1] - '0';  //这里就是dp[1]对应ch[0],如果第一个字符符合1~9的要求,则可以解码一种方法 ,这里其实是f(n-1).
            if (t >= 1 && t <= 9) {
                dp[i] += dp[i - 1]; //原本dp[1]初始为0,这边符合要求,则初始就为1啦.
            }
            if (i >= 2) {  //这里是f(n-2);
                int x = ch[i - 2] - '0';
                int y = ch[i - 1] - '0';
                int z = x * 10 + y;
                if (z >= 10 && z <= 26) {
                    dp[i] += dp[i - 2];  //##加上f(n-2)的方法数.
                }
            }
        }
        return dp[n];
    }
}
