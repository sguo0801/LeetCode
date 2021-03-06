package 数据结构.位运算;

public class 两整数之和371 {
    class Solution {
        //可以循环可以递归
        //5-101，7-111 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
        //第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
        //第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
        //继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。

        //a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
        //递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，
        //每一次进位都右边多0,可能后面会变成1000000,而左边a^b固定长度,所以取a&b时循环(递归)几次后面肯定为0,最后进位会变为 0，递归终止.
        public int getSum(int a, int b) {
            return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        }
    }
}
