package 算法.数学.进制转换;
//竟然发现不能更新到github
//因为从1 -> "A"开始,所以先n-1,才不会26时,递归出一个1;所以n-1并以A为基准做偏差,递归肯定会出现0,就正好有"",将后面的字符进行转换.
public class 二十六进制转换168 {
    class Solution {
        public String convertToTitle(int n) {
            return n == 0 ? "" : convertToTitle(--n/26) + (char)(n % 26 + 'A');   //注意强转是(char)(),都要加括号
        }
    }
}
