package 数据结构.位运算;

public class _2的幂231 {
    //    class Solution {
//        public boolean isPowerOfTwo(int n) {
//            //2的幂次就是代表二进制只有一个1存在
//            //一种是直接用Integer.bitcount()统计1的个数
//            return n > 0 && Integer.bitCount(n) == 1;
//        }
//    }
    class Solution {
        public boolean isPowerOfTwo(int n) {
            //另一种就是通过n&(n-1)可以得到去除最低位的1.那么只有一个1.则为0
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
