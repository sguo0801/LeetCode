package 算法.动态规划.最长递增子序列;

import java.util.Arrays;

public class 最长数对链646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);  //将 数对按头(左边界,从小到大排序).即便相同也没关系,后面会整个遍历on2
        int[] dp = new int[pairs.length];  //dp表示以当前数对为结尾的链长度.这种思路与最长子序列是一样的,注意dp初始的区别
        Arrays.fill(dp, 1); //初始值这里为1.因为一个数对也是一个长度为1 的链.要整个dp赋值为1,否则初始数对要是比较大,后面会为0.
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {  //j是从前往后的尾跟当前元素的头作比较
                if (pairs[j][1] < pairs[i][0]) {
                    //dp[i]随着j的增大而增大
                    dp[i] = Math.max(dp[j] + 1, dp[i]);  //这一步相当于内循环更新dp[i],外循环给整个dp数组赋值.dp[i]初始均为1
                }
            }
        }

        int max = 0;
        for (int a : dp) {
            max = Math.max(a, max);
        }
        return max;
    }
}
