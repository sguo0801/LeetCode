package 算法.数学.字符串加减;

public class 字符串相加415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;  //这里为溢出值
            StringBuilder sb = new StringBuilder();
            while(i >= 0 || j >= 0 || carry != 0){  //只要溢出位还在,就要加在sb最后面(也就是最大值),而且溢出位只能为0或1,所以这里也可以写 carry==1
                int x = i < 0 ? 0 : num1.charAt(i--) - '0';  //i<0,代表num1已经加完了.
                int y = j < 0 ? 0 : num2.charAt(j--) - '0';
                sb.append((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
            }
            return sb.reverse().toString();
        }
    }
}
