package 算法.动态规划.最长递增子序列;
//只有一个序列,且dp必须包括最后的字母,需要遍历求max
//on2的方法,onlogn方法在源头,不是很懂?????
//O(N^2)的解法容易想到, 分享一个O(NlogN)的解法 here
//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        /**
//        dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
//        由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
//        对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
//        1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
//           数组尾部, 并将最长递增序列长度maxL加1
//        2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
//        **/
//        int maxL = 0;
//        int[] dp = new int[nums.length];
//        for(int num : nums) {
//            // 二分法查找, 也可以调用库函数如binary_search
//            int lo = 0, hi = maxL;
//            while(lo < hi) {
//                int mid = lo+(hi-lo)/2;
//                if(dp[mid] < num)
//                    lo = mid+1;
//                else
//                    hi = mid;
//            }
//            dp[lo] = num;
//            if(lo == maxL)
//                maxL++;
//        }
//        return maxL;
//    }
//}
public class 最长上升子序列300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];  //dp是以当前元素为结尾的最长子序列的长度,可以没有前面的大.
        dp[0] = 1;  //时刻注意dp数组的初始,设置好值.
        int max;
        for (int i = 1; i < nums.length; i++) {
            max = 1; //从第二个元素开始,先有一个元素,则长度初始为1,且每轮循环更新
            for (int j = 0; j < i; j++) {  //从0到i-1找比nums[i]小的
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);  //如果比nums[j]大,则长度可以在dp[j]上直接+1.
                }
            }
            dp[i] = max;  //保存当前元素nums[i]为结尾的最大子序列长度.
        }

        max = 0;
        for (int a : dp) {
            max = Math.max(a, max);
        }
        return max;
    }
}
