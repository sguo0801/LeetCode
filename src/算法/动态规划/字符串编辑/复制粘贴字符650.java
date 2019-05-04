package 动态规划.字符串编辑;
//如果这个数是质数 则这个数只能一个一个的复制得到 操作步数就是这个数本身 如果不是质数 则可以由复制得到 例如20可以由10复制得到 10可以由5复制得到 而5是质数 只能一个一个复制 所以minStep （20） = 9
//法一,就是递归,
public class 复制粘贴字符650 {
    class Solution {
        public int minSteps(int n) {
            if(n == 1){
                return 0;
            }
            for(int i = 2; i <= n; i++){
                if(n % i == 0){
                    return minSteps(n/i) + i;
                }
            }
            return n;
        }
    }
    //法二就是迭代,比较不错!.
//    class Solution {
//        public int minSteps(int n) {
//            if(n == 1){
//                return 0;
//            }
//            int res = 0;
//            for(int i = 2; i <= n; i++){
//                while (n % i == 0){  //比如有4这个因子,就是两个2,直到没办法对其取余,
//                    res += i;  //迭代的方法进行求解.
//                    n /= i;  //n变小.
//                }
//            }
//            return res;
//        }
//    }
    //法三动归不好.
    //public int minSteps(int n) {
    //    int[] dp = new int[n + 1];
    //    int h = (int) Math.sqrt(n);
    //    for (int i = 2; i <= n; i++) {
    //        dp[i] = i;
    //        for (int j = 2; j <= h; j++) {
    //            if (i % j == 0) {
    //                dp[i] = dp[j] + dp[i / j];
    //                break;
    //            }
    //        }
    //    }
    //    return dp[n];
    //}
}
