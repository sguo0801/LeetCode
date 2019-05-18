package 数据结构.数组和矩阵;

public class 数组嵌套565 {
    class Solution {
        public int arrayNesting(int[] nums) {
            //以各个数为起点,然后走过的数标记为-1,直到停止看长度.再进行求max
            int max = 0;
            for (int i = 0; i < nums.length; i++) {  //这边是作为起点的各个索引
                int count = 0;
                int j = i;   //不能动i,否则后面循环会出问题
                while (nums[j] != -1) {
                    count++;
                    int temp = nums[j];  //先把值存下来
                    nums[j] = -1;      //进行标记
                    j = temp;

                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
