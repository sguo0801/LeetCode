package Top100;

import java.util.*;
//把每个字符变成字符数组,进行排序,则相同为同一组,map里面key要为String类型,且不能直接put初值,先建立空的ArrayList,再填数.
public class _49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs == null || strs.length == 0){
                return new ArrayList<List<String>>();
            }

            //必须是key为String,不能为char[]类型.???
            Map<String, List<String>> map = new HashMap<>();
            for(String s : strs){
                char[] c = s.toCharArray();
                Arrays.sort(c);
                String key = String.valueOf(c);
                if(! map.containsKey(key))
                    map.put(key, new ArrayList<String>());   //map的value,初始不能赋值

                map.get(key).add(s);

            }
            return new ArrayList<List<String>>(map.values());  //这里写成new ArrayList<List<String>>(map.valuee())或new ArrayList(map.values());都可以.
        }
    }
}
