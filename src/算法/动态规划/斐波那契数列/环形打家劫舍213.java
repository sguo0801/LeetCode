package 动态规划.斐波那契数列;

public class 环形打家劫舍213 {
        public int rob(int[] nums) {  //思路要清晰,是比较pre1  ,pre2跟nums[i]和  的大值作为保留.只不过有环划定了始末重点范围.
            //不需要考虑奇偶,因为并不是一定按照只隔一个数进行取值.关键比较上面这两个值的大小.
            if(nums == null || nums.length == 0){
                return 0;
            }
            if(nums.length == 1){
                return nums[0];
            }
            int n = nums.length; //注意长度用参数表示,会更清晰
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n -1)); //比较两种情况的各自最大值

        }

        private int rob(int[] nums, int start, int end){
            int pre1 = 0;
            int pre2 = 0;
            for(int i = start; i <= end; i++){
                int cur = Math.max(pre1, pre2 + nums[i]);
                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }
}
