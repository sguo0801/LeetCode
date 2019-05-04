package 动态规划.数组区间;
//这种题目就是规律不好找,。如果有3个等差数字 则dp[3] = 1 .前两个dp自然为0.都凑不够三个等差的条件.
// 现在再后面加一个等差数字,dp数组 中dp[4] =2.都是只新加的符合条件的等差数列数,这里是后三个数234,和全部四个数1234组成的两个等差数列
//dp[5] = 3 包括12345, 2345, 345.可得dp[i] = dp[i - 1] + 1;
public class 等差数列划分413 {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {  //从2开始凑够三个数,跟前面比较
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1; //之前如果没有出现等差则默认为0.这边遇到后正好初始值为1.
            }
        }
        int res = 0;
        for (int temp : dp) {
            res += temp;
        }
        return res;
    }
}
