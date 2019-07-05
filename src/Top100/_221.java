package Top100;

public class _221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            //dp[i][j] 是以i-1,j-1这个数作为正方体右下角的点的时候的边长(不一定为最大),也就是这个点左上,左,上三个点都是1时,才会增加边长.
            //如果i-1,j-1的位置为0,则dp[i][j] = 0;
            if(matrix.length == 0){
                return 0;   //####必须有边界判断,否则n就会越界!!!!!!
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m+1][n+1];
            int maxbian = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(matrix[i-1][j-1] == '1'){  //##这边是i-1,j-1的位置.也就是dp[i][j]对应matrix[i-1][j-1]为右下角的时候.
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                        maxbian = Math.max(dp[i][j], maxbian);
                    }
                }
            }
            return maxbian * maxbian;
        }
    }
}
