package 数据结构.字符串;

public class 同构字符串205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            //题目中假设了两字符串长度相同.
            //记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
            //使用两个数组标记,再次遇到同一个字符的时候,两个数组中上一次的标记值是否相同
            int[] indexs = new int[256];   //不一定都是字母,所以用256个长度的数组
            int[] indext = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (indexs[s.charAt(i)] != indext[t.charAt(i)]) {
                    return false;
                }
                indexs[s.charAt(i)] = indext[t.charAt(i)] = i + 2;  //这边i+1,或者i+2都是一样的,主要是标记,不是0就好.
            }
            return true;
        }
    }
}
