package 数据结构.字符串;

public class 计数二进制子串696 {
    //pre记录之前连续0或1，cur记录现在的连续1或0，pre>=cur,比如现在有1个1，那么之前有1个或者2个、3个0，01、001、0001、都包含一个符合条件的解01，即满足条件。
    class Solution {
        public int countBinarySubstrings(String s) {
            int pre = 0, cur = 1, count = 0;  //这边cur是为了避免第一个数就使count+1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    cur++;  //从最开始还没有pre.都是当前的数.可能从0变成00这样
                } else {
                    pre = cur;
                    cur = 1;  //这边是遇到不同,则更新pre和cur,cur=1是指遇到当前不同值,个数起始为1.
                }
                if (pre >= cur) {
                    count++;
                }
            }
            return count;
        }
    }
}
