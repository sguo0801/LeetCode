package Top100;

import java.util.HashMap;
//用哈希表,一边找匹配的数,一边往里填匹配不成功的数
public class _1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i ++){
                if(map.containsKey(target-nums[i])){  //从后往前看
                    return new int[]{map.get(target-nums[i]), i};//返回的数组都是索引.
                }
                map.put(nums[i], i);//key为值数组的值,value为该值对应的索引.
            }
            return new int[0];
        }
    }
}
