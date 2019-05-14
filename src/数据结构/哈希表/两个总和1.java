package 数据结构.哈希表;

import java.util.HashMap;

public class 两个总和1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //这里用HashMap来做,空间换时间
            //把nums[i]当做key,因为只有两个数,所以用target-nums[i]来找另一个索引即可
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};  //i的索引会更大一些
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
