package 数据结构.数组和矩阵;

public class 重塑矩阵566 {
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            //先判断行列积是否相同,然后设置定义索引,填充新矩阵,注意到新矩阵的行列,是index/c和index%c.都是看列的关系.按层遍历
            int left = nums.length;
            int right = nums[0].length;
            if (left * right != r * c) {
                return nums;
            }
            int index = 0;
            int[][] newShape = new int[r][c]; //建立新的空矩阵
            for (int i = 0; i < left; i++) {
                for (int j = 0; j < right; j++) {
                    //这边是按层遍历原矩阵
                    newShape[index / c][index % c] = nums[i][j];  //都是跟列c的运算
                    index++;
                }
            }
            return newShape;
        }
    }
}
