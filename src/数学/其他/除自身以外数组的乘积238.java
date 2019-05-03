package 数学.其他;
//很懵,仿佛是背下来的
public class 除自身以外数组的乘积238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for(int i = 1; i < n; i++){
                res[i] = res[i-1] * nums[i-1];
            }

            int right = 1;
            for(int j = n-1; j >= 0; j--){
                res[j] *= right;
                right *= nums[j];
            }
            return res;
        }
    }
}
