package 数据结构.字符串;
//思路:先把每个字符的出现次数放进数组.然后遍历数组时,只要2以上次数的都可以添加.用/2*2操作可以无所谓奇偶,最后多的字符长度再+1.可以放在最中间.
public class 最长回文串409 {
    class Solution {
        public int longestPalindrome(String s) {
            //只要有2个及2个以上的出现次数,一定可以添加进最长回文串,添加进去的长度是n/2*2,,比如有3个a,那么添加2(3/2*2)个;
            //最后只要有多的字符,就可以添加到最中间.则最后长度可能再+1.
            int[] cur = new int[128];  //这边是'A'对应65,'a'对应97,'z'对应122,只要能包括从'A'到'z'即可,中间可以不用管.
            for (char c : s.toCharArray()) {
                cur[c - 'A']++;   //可以直接用字符的int值作为索引,因为最大也就122,够用的
            }
            int res = 0;
            for (int i : cur) {
                res += i / 2 * 2;
            }
            if (res < s.length()) {
                res++;
            }
            return res;
        }
    }
}
