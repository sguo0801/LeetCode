package 数据结构.位运算;

public class 交替位二进制数693 {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            //如果这个正整数右移,应该从1010变成101,就是两者异或必然是1111.
            int z = n ^ (n >> 1);  //对于正整数来讲>>与>>>相同.
            return (z & (z+1)) == 0; //再+1,则只有一个1,所以去掉最低位的1,即0;
        }
    }
}
