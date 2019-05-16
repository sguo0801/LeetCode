package 数据结构.字符串;

public class 两个字符包含字符是否相同242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            //可以用HashMap进行映射,也可以用数组进行分别遍历两个数组,进行士兵策略
            int[] help = new int[26];
            for (char c : s.toCharArray()) {
                help[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                help[c - 'a']--;
            }
            for (int i : help) {  //数组也可以用foreach循环
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
