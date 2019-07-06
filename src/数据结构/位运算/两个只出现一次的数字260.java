package 数据结构.位运算;

public class 两个只出现一次的数字260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int res = 0;
            for(int i : nums){
                res ^= i;
            }
            res &= -res;  //n&(-n)求得最低位的1,也就是两个数最低的不同位,比如000000100;
            int[] diff = new int[2];  //初始默认为0;
            for(int i : nums){
                if((i & res) == 0){  //#####必须是0;因为不知道这个1是在哪一位上,如果这边写1.那么指的是最后一位为1.所以不成立,与两个数之间的位置无关
                    diff[0] ^= i;
                }else{
                    diff[1] ^= i;
                }
            }
            return diff;
        }

    }
}
