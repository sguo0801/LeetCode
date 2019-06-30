package Top100;

import java.util.HashMap;

public class _3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //每遇到重复的字符,则将左索引j更新到上一个重复字符的右侧,这样说明后面 重复字符的左边就不计啦
            if(s == null || s.length() == 0){    //什么都没有null或者无字符""就0;全部是空字符" "是1,都是空字符"  "还是1
                return 0;
            }
            int max = 0;
            HashMap<Character, Integer>  map = new HashMap<>();  //哈希表中放每个字符的最后一个字符串中的位置.
            for(int i = 0, j = 0; i < s.length(); i++){
                if(map.containsKey(s.charAt(i))){
                    j = Math.max(j, map.get(s.charAt(i)) + 1);  //重复则调整左索引j到最后一个已经重复值的右边,所以有比较,j不能回头

                }
                map.put(s.charAt(i), i);  //无论存在与否都更新位置.
                max = Math.max(max, i-j+1);
            }
            return max;
        }
    }
//用数组进行标记来判断.速度会跟快
    //public int lengthOfLongestSubstring(String s) {
    //        int result = 0;
    //        int[] cache = new int[256];
    //        for (int i = 0, j = 0; i < s.length(); i++) {
    //            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j; //字符作为数组索引,比如'a'就是97
    //            cache[s.charAt(i)] = i + 1;
    //            result = Math.max(result, i - j + 1);
    //        }
    //        return result;
    //    }
}
