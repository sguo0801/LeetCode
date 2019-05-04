package 算法.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 根据字符出现频率排序451 {
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : ch) {  //1.统计字符次数的map
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //2.把相同频率的字符放一起,在桶数组中,且索引为次数.
        ArrayList<Character>[] bucket = new ArrayList[ch.length + 1];
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            int times = set.getValue();
            if (bucket[times] == null) {
                bucket[times] = new ArrayList<Character>();  //注意别敲错,然后有<>();
                bucket[times].add(set.getKey());
            } else {
                bucket[times].add(set.getKey());
            }
        }

        //3.放入对应String中,每个字符打印times次
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i > 0; i--) { // 0带不带无所谓,打印0次无意义
            if (bucket[i] == null) {
                continue;
            } else {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < i; j++) {  //不能用i做减法.i不要变,i应该作为常量,否则变成就没有第二次for(c:bucket[i])了,第一次是这里出了问题
                        sb.append(c);
                    }
                }
            }
        }
        return String.valueOf(sb);
    }
}
