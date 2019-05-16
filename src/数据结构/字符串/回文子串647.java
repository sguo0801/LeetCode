package 数据结构.字符串;

public class 回文子串647 {
    class Solution {
        private int count = 0;

        public int countSubstrings(String s) {
            //从某一个字符开始,左右扩展看是否为回文子串
            if (s.equals("") || s.length() == 0) {  //这边边界条件左边s==null也可以
                return 0;
            }
            for (int i = 0; i < s.length(); i++) {
                find(s, i, i);   //奇数个字符组成的子串
                find(s, i, i + 1);  //偶数个字符组成的子串
            }
            return count;

        }

        private void find(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                count++;
            }
        }
    }
}
