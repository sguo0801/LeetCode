package 数据结构.位运算;

public class _4的幂342 {
    //    class Solution {
//        public boolean isPowerOfFour(int num) {
//            //4的幂就是二进制只有一个1且在第奇数次位上,比如0001,0100,
//            return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;  //必须前面写0b否则会默认int类型.
//        }
//    }
    class Solution {
        public boolean isPowerOfFour(int num) {
            //正则表达式
            return Integer.toString(num, 4).matches("10*");  //直接变成四进制,然后看是不是与10,或1后面加n个0匹配.其实就是判断只有一个1.
        }
    }
}
