package Top100;

import java.util.List;

public class _524 {
    //先挨个遍历字典,看s字符是否满足被包含,之后的字符可以先判断是否长度更小,或者字典序在后.如果满足再看是否被包含.
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longestWord = "";
            for(String t : d){
                int length  = longestWord.length();
                int temp = t.length();
                if(length > temp || (length == temp && longestWord.compareTo(t) < 0)){ //用字典序判断前后,小于0则说明字典序小在前
                    continue;
                }
                if(cont(s, t)){
                    longestWord = t;
                }
            }
            return longestWord;
        }

        public boolean cont(String s, String t){
            int i = 0;  //双指针,s的
            int j = 0;  //t的
            while(i < s.length() && j < t.length()){  //往后遍历字符,直到有一个字符遍历完毕
                if(s.charAt(i) == t.charAt(j)){
                    j++;
                }
                i++;
            }
            return j == t.length(); //说明t被包含.
        }
    }
}
