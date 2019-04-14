package 动态规划;

public class 最小路径和64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; //dp矩阵指的是每个位置是加上该位置之后和前面的最小值情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) { //就是第一个数,最左上角,只能加上本身,左上均没有数
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {  //因为是要加上这个位置,而i = 0.说明是在第一行,只能从左边的数移动到这里,即左边的和(dp)加上本身(grid).
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]); //本身是肯定要加的,就看是加dp中左还是上啦,取小的那个
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
