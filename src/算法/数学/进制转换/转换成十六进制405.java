package 算法.数学.进制转换;

public class 转换成十六进制405 {
    class Solution {
//1．通常把一个数的最高为定义为符号位，用“0”表示正，用“1”表示负。
//因为【－1】为负，所以【－1】的原码＝10000001
//2.反码：对于负数，数符位为1，数符位不变，将数值位诸位取反为反码。
//【－1】的反码＝11111110
//3.补码：对于负数，数符位为1，数符位不变，将反码＋1＝补码。
//【－1】的补码＝11111111
//-1的补码是32个1,因为是32位的,所以与0xf与&.还是本身,右移时用>>>,这样高位补0,否则用>>高位补1,就永远不能结束循环.,或者就是用>>,还要在while条件中加上sb.length()<8,这样可以保证循环结束.
        public String toHex(int num) {
            String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};  //"0"是补位的,后面map的索引
            if (num == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();

            while (num != 0) {  //有负数,条件不能写>0.
                //这里可以append添加字符或者数字之类的,会自己转换成字符串形式添加到sb末端.
                //这里oxf是指二进制1111.思路就是通过&这个位运算让num自动化为二进制数,然后从尾部开始,一次取四位二进制数.这个二进制对应的十六进制在map表中.
                // 所以以此时二进制数的十进制作为索引.找到十六进制的数添加到末端(但是先添加,其实是整个sb的首段,最后要反转.
                //之后把最低位的四位右移去掉,并且在最高位补0,所以采用>>>.三个.逻辑右移补0!(>>算数右移补1)
                sb.append(map[num & 0xf]);  //位运算都是指二进制运算,这里是把十进制的num变成二进制,且每四位二进制对应一个十六进制数,并且这里先添加到sb中的是最低位二进制4个数,也就是十六进制的最低位.
                num >>>= 4;  //右移四位,把之前已经添加的值去掉,一定要用>>>逻辑右移,高位补0,最后遍历所有
            }
            return sb.reverse().toString();
        }
    }
}
