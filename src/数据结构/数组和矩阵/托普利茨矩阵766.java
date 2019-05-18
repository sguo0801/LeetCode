package 数据结构.数组和矩阵;

public class 托普利茨矩阵766 {
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            //正常根据题意去做,注意从0开始就要到length-1.跟右下比较
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
