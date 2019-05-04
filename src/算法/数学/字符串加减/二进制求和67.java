package 数学.字符串加减;

public class 二进制求和67 {
    class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;  //字符串索引,从最大值(最后面对应二进制的较小数)开始
            int carry = 0; //保存当前位的值或者溢出值
            StringBuilder sb = new StringBuilder();
            while(carry == 1 || i >= 0 || j >= 0){  //==1代表最高位溢出了一个1
                if(i >= 0 && a.charAt(i--) == '1'){  //只有为'1'才可以加值,且要更新i,j索引
                    carry++;
                }
                if(j >= 0 && b.charAt(j--) == '1'){
                    carry++;
                }
                sb.append(carry%2);  //如果carry=2,则最后加0.
                carry /= 2;  //carry为溢出的1.
            }
            return sb.reverse().toString();
        }
    }
}
