package 数据结构.哈希表;

import java.util.HashMap;

public class 最长和谐子序列594 {
    class Solution {
        public int findLHS(int[] nums) {
            //因为不要求连续,所以可以把数字对应次数放在hashmap中,看相邻数组的次数最大值即可.
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int count = 0;
            for (int key : map.keySet()) {  //直接用keySet(),相比于从头遍历数组可以把没有出现过的数字去掉
                if (map.containsKey(key + 1)) {
                    count = Math.max(count, map.get(key) + map.get(key + 1));
                }
            }
            return count;
        }
    }
}
