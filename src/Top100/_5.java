package Top100;

public class _5 {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {  //可以到最后一个字母,
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);   //s1为奇数(每次开始都是字母本身,肯定说是回文),s2为偶数时的回文字符串
            if (s1.length() > max.length()) max = s1;  //比较的是上次更新后的子字符串长度
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);  //substring不包括后面的索引,所以j出界没事,但是i为-1时要加1才可以.
    }
}
