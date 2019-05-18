package 数据结构.数组和矩阵;

public class 最多能完成排序的块769 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null || arr.length == 0) {  //注意边界条件
                return 0;
            }
            int res = 0;
            int right = 0;
            for (int i = 0; i < arr.length; i++) {  //确定当前的最右的值
                right = Math.max(arr[i], right);
                if (right == i) {
                    res++;   //这道题目是索引与数值应该对应的.都是从0开始.
                }
            }
            return res;
        }
    }
}
