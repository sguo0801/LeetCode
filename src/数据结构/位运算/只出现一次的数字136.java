package 数据结构.位运算;

public class 只出现一次的数字136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int i : nums){
                res ^= i;
            }
            return res;
        }
    }
}
