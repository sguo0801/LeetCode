package 算法.贪心思想;

public class 最大子序和53 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];  //代表加上当前值的最大值
            int res = nums[0]; //代表之前保存过的最大值
            for(int i = 1; i < nums.length; i++){  //只要不是完全遍历的不要用foreach
                max = Math.max(max + nums[i], nums[i]);   //很简单,就是肯定包含当前值,看要不要之前的.
                res = Math.max(max, res);  //看新的max值和之前最大值比较.
            }
            return res;
        }
}
