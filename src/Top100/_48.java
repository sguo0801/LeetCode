package Top100;
//顺时针旋转,就是先首末行交换,一直到中间行.之后沿左上右下对角线进行交换对角线两侧值即可.
//逆时针旋转,就是先首列行交换,一直到中间列.之后沿左上右下对角线进行交换对角线两侧值即可.
public class _48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int s = matrix.length-1;
            int e = 0;
            while(e < s){
                //先是上下行交换从顶末到中心.
                int[] temp = matrix[s];
                matrix[s] = matrix[e];
                matrix[e] = temp;
                s--;
                e++;
            }
            //按左上右下对角线对称,需要的就是找到一侧的值交换即可,比如只考虑对角线右上部分.
            for(int i = 0; i < matrix.length; i ++){
                for(int j = i + 1; j < matrix[i].length; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

        }
    }
}
