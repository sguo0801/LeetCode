package 数据结构.数组和矩阵;

public class 最大连续1的个数485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            //通过一个cur来计算1的个数,且每遇到0,cur就置0.
            int cur = 0;
            int max = 0;
            for (int num : nums) {
                cur = num == 0 ? 0 : cur + 1;
                max = Math.max(cur, max);
            }
            return max;
        }
    }
}
