package 算法.动态规划.背包;

import java.util.Arrays;
//dfs会超时
//使用dp数组，dp[i]代表组合数为i时使用nums中的数能组成的组合数的个数
//别怪我写的这么完整
//dp[i]=dp[i-nums[0]]+dp[i-nums[1]]+dp[i=nums[2]]+...
//举个例子比如nums=[1,3,4],target=7;
//dp[7]=dp[6]+dp[4]+dp[3]
//其实就是说7的组合数可以由三部分组成，1和dp[6]，3和dp[4],4和dp[3];

public class 组合总和377 {
    //    public int combinationSum4(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        Arrays.sort(nums);  //nums[j]<=i写在条件里就需要排序.
//        for (int i = 1; i <= target; i++) {
//            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
//                dp[i] += dp[i - nums[j]];
//            }
//        }
//        return dp[target];
//
//    }
    //这样写不需要排序.
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            //是为了算上自己的情况，比如dp[1]可以由dp[0]和1这个数的这种情况组成。
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num) {
                        dp[i] += dp[i - num];  //就是每一个dp[i-num]数量和num这个数就是一种组合.
                    }
                }
            }
            return dp[target];
        }
    }
}
