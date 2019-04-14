package 动态规划;

public class 完全平方数279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {  //dp数组索引.
            dp[i] = dp[i - 1] + 1;  //先默认+1
            if (isSquare(i)) { //如果是平方数,则更新为1.
                dp[i] = 1;
            }
            for (int j = 1; j * j < i; j++) { //是调整不规范的数,减掉平方数乘积后(值缩小) 加上对应的个数1即可.
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    private boolean isSquare(int i) { //判断是否为平方数
        if (Math.sqrt(i) == Math.ceil(Math.pow(i, 0.5))) {  //ceil是向上取整.只有平方数(开根号后,没有小数,则才相等),这边Math.pow(i, 0.5)与Math.sqrt(i)等价,要注意0.5不能写成1/2.
            return true;
        } else {
            return false;
        }
    }
}
