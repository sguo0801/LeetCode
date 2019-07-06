package 数据结构.数组和矩阵;

public class 搜索二维矩阵240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int row = 0;
            int col = n - 1;
            while (row < m && col >= 0) {
                if (target == matrix[row][col]) { //##注意别马虎写错[]
                    return true;
                } else if (target > matrix[row][col]) {  //##别马虎 写错target
                    row++;
                } else {
                    col--;
                }
            }
            return false;  //遍历光了还是没有,则false;
        }
    }
}
