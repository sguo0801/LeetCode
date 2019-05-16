package 数据结构.数组和矩阵;

public class 移动零283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            //数组中的0忽略不计,把非0往前拷贝,最后补0;
            int index = 0;  //定义索引
            for (int num : nums) {
                if (num != 0) {
                    nums[index++] = num;
                }
            }
            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }
}
