package Sequence;

import java.util.HashMap;

public class _1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i ++){
                if(map.containsKey(target-nums[i])){  //从后往前看
                    return new int[]{map.get(target-nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
