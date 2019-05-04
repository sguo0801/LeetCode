package 算法.动态规划.矩阵路径;
public class 不同路径62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            //把第一列全标为1.因为这些地方只有一种走法,第一行也一样,Arrays.fill(int[], n)只能填充一维数组,填充值是后面的数n,所以这里二维数组只能赋值
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}

//法二,是数学问题机器人总共移动的次数 S=m+n-2，向下移动的次数 D=m-1，那么问题可以看成从 S 中取出 D 个位置的组合数量,这个问题的解为 C(S, D)。
class Solution{
    public  int uniquePaths(int m, int n){
        int S = m + n - 2;
        int D = m - 1;
        long res = 1;  //注意是long型,防止溢出
        for (int i = 1; i <= D; i++){
            res = res * (S - D + i) / i;  //求排列组合的公式.重点
        }
        return (int)res;  //返回int,题中要求.
    }
}