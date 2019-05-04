package 算法.动态规划.斐波那契数列;

public class 打家劫舍198 {
        public int rob(int[] nums) {
            int pre1 = 0;
            int pre2 = 0;  //都是当前 的前几天金额.
            for(int i = 0; i < nums.length; i++){
                int cur = Math.max(pre1, nums[i] + pre2);
                pre2 = pre1; //相当于后移,进行迭代的过程
                pre1 = cur;
            }
            return pre1;
        }
}
