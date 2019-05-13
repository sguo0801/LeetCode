package 数据结构.位运算;

public class 翻转一个数的比特位190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //根据x|1s=1s,和x|0s=x.这里与1取或
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1; //每次循环先把解左移,相当于在res后面加值,左移后原来位置填0,或后面(n&1)的结果,后面为0,或与x相同还是0;后面为1,或与1相同
                res |= (n & 1);
                n >>= 1;  //就是n右移填到res左边.这边>>还是>>>都行,只有负数用>>前面才可能出现1;0000这种应该是还是前面补0;
            }
            return res;
        }
    }
}
