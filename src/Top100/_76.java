package Top100;

import java.util.HashMap;
//最小覆盖子串,使用双指针+HashMap进行求解.
public class _76 {
    class Solution {
        //解题是最终找到最小子串开始的left索引和最小子串的长度
        public String minWindow(String s, String t) {
            if (s == null || s.length() < t.length() || s.length() == 0) {
                return "";
            }
            //1.先建立一个map装t中的字符及次数.
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            int count = 0;  //根据t.length()比较判断是否包含所有t.
            int left = 0;   //左边索引,当已经包含t时,开始右移,找下一个minlen
            int minleft = 0; //只要包含时,left就升级成minleft,进行计算len
            int minlen = s.length() + 1;  //终极目标找到最小的minlen,通过每次包含满足时进行比较.##与下面判断同等长度不同字符串进行呼应,所以+1

            //2.开始遍历right索引,找到包含情况.找到一个map中的字符就进行次数-1,只要次数=>0,就count++.(先减再看与0比较)
            for (int right = 0; right < s.length(); right++) {
                if (map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    if (map.get(s.charAt(right)) >= 0) {  //##与下面left索引右移要注意,map中次数减到>=0就不再增加count,即便是表中相同的字符
                        count++;
                    }
                }

                //3.满足了包含条件,开始计算长度.
                while (count == t.length()) {  //##可能右侧是非t中字符,则left右移还是满足,这边是直到满足为止,持续更新minlen和minleft

                    if (right - left + 1 < minlen) { //##因为minlen初始为length()+1,所以是<
                        minleft = left;
                        minlen = right - left + 1;
                    }


                    //4.已经满足啦,就可以left右移,找下一次包含
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);  //把最左边包含的字符剔除窗口,则该字符在map中就要数量+1;注意改map中values要用put.
                        if (map.get(s.charAt(left)) > 0) {//##即便是表中相同的字符,如果map中次数加1后<=0,也不改变减少count.因为是多余的字符.
                            count--;
                        }
                    }
                    left++;  //无论是否最左侧字符是map中的字符,这边left索引均右移,直到不满足包含,再右移right


                }
            }

            //5.如果只有"a"与"b"不同,这里通过minlen不发生变化则比s.length()长(初始设置length()+1)进行判断.
            if (minlen > s.length()){
                return "";
            }
            return s.substring(minleft, minleft + minlen);
        }
    }
}
