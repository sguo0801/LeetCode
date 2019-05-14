package 数据结构.哈希表;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            //利用set的不重复性
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set.size() < nums.length;
        }
    }
}
