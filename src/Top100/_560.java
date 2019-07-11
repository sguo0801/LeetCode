package Top100;

import java.util.HashMap;
import java.util.Map;

public class _560 {
    public class Solution {
        // 思路：
//    sum[i]表示num[0:i]的子数组和，那么num[i:j]的和等于sum[j] - sum[i]
//    遍历sum数组检查 sum[j] - sum[i] == k
        public int subarraySum(int[] nums, int k) {
            int sum = 0, result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);  //这里是和为0,有1种方法,值为方法数,键为能组成的和.

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }

            return result;
        }
    }
}
