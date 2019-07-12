package Top100;

import java.util.HashSet;
//珠宝建一个set
//通过看是否包含S中的字符进行统计.
//哈希集，它是O（1）来检查它是否包含一个元素。
//所以总时间复杂度将是O（M + N），而不是O（MN）
public class _771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            int res = 0;
            HashSet<Character> set = new HashSet<>();
            for(char j : J.toCharArray()){
                set.add(j);
            }
            for(char s : S.toCharArray()){
                if(set.contains(s)){
                    res++;
                }
            }
            return res;
        }
    }
}
