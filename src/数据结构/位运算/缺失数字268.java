package 数据结构.位运算;

public class 缺失数字268 {
    class Solution {
        //通过异或,其实数组中最大的数就是长度值
        public int missingNumber(int[] nums) {
            int res = 0;
            for(int i = 0; i < nums.length; i++){
                res ^= i ^ nums[i];
            }
            return res ^ nums.length;
        }
    }
}
