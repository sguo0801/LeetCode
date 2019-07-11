package 数据结构.位运算;
//主要思路是^上对应位数的1111.
public class 数字的补码476 {
    class Solution {
        public int findComplement(int num) {
            //求补码即已知x求-x;使用x^1s的方式即可,所以比如求101,即先求掩码(对当前二进制进行位与运算,屏蔽输入位)111,再进行异或
            //求掩码要从最高位开始找x的第一个1,然后对应1000,再左移1,再-1即可得到1111.
            int mask = 1 << 30;  //现在是1后面30个0.即最高位1
            while((mask & num) == 0){
                mask >>= 1;  //逐渐逼近num的最高位1
            }
            //目前是101,已经得到100
            mask = (mask << 1) - 1;  //左右都是二进制,所以可以这么写
            return num ^ mask;

            //求掩码还可以
//            int mask = num;
//            mask |= mask >> 1;
//            mask |= mask >> 2;
//            mask |= mask >> 4;
//            mask |= mask >> 8;
//            mask |= mask >> 16;
        }
    }
}
