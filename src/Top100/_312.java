package Top100;

public class _312 {
//    请注意，dp行将dp [left] [right]分配给nums [left] * nums [i] * nums [right] + dp [left] [i] + dp [i] [right]）
//    dp [left] [i]和dp [i] [right]）当k = 2时等于基本情况！等于0！我们总是引用先前迭代的值。
//    继续增加左右之间的气球数量，直到我们到达最后的情况left = 0和right = n-1


    //标准解法:https://www.cnblogs.com/njufl/p/LeetCode.html
    class Solution {
        public int maxCoins(int[] nums) {
            int[] nnums = new int[nums.length + 2];  //新的数组.加了两个边界
            int n = 1;  //索引
            for (int num : nums) {  //这边不需要判断num>0吧,无影响?
                nnums[n++] = num;
            }
            nnums[0] = nnums[n++] = 1;  //最前和最后置1.
            int[][] dp = new int[n][n];  //此时的n已经是比原来多2啦.
            for (int k = 2; k < n; k++) {   //k从2开始,是因为要有中间的数在left和right之间.所以差距从2开始.且为2时只有乘积nnums[left] * nnums[i] * nnums[right],没有相加,因为开区间,left和i之间已经没有数啦,
                for (int left = 0; left < n - k; left++) {
                    int right = left + k;
                    for (int i = left + 1; i < right; i++) {
                        dp[left][right] = Math.max(dp[left][right], nnums[left] * nnums[i] * nnums[right] + dp[left][i] + dp[i][right]);   //右边这两个+,不包括left,right,i
                    }
                }

            }
            return dp[0][n - 1];
        }

    }
}
