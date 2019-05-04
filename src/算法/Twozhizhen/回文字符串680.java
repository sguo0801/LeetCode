package Twozhizhen;

public class 回文字符串680 {
    public boolean validPalindrome(String s) {
        int i = -1;
        int j = s.length();
        char[] ch = s.toCharArray();
        while (++i < --j) {  //这边可以放++--,是因为特意改了初始值
            if (ch[i] != ch[j]) {
                return isExchange(ch, i + 1, j) || isExchange(ch, i, j - 1);  //给一次机会
            }
        }
        return true;
    }

    public boolean isExchange(char[] ch, int i, int j) {
        while (i < j) {
            if (ch[i++] != ch[j--]) { //不能把++--放在while中,下面对应的值会变化
                return false;
            }
        }
        return true;
    }
}
