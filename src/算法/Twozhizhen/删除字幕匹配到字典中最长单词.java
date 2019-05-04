package Twozhizhen;

import java.util.List;
//关于compareTo ,和通过遍历后指针==长度 判断包含关系.很棒!
public class 删除字幕匹配到字典中最长单词 {
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
