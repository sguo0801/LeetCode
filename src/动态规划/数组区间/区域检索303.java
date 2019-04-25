package 动态规划.数组区间;

public class 区域检索303 {
    //问题在哪里???
//    class NumArray {
//        private int[] sums;
//
//        public NumArray(int[] nums) {
//            sums = new int[nums.length];
//            sums[0] = nums[0]; //sums也是从0~n-1的.只不过代表之前到现在的所有和.#########问题在这里!??????
//            for(int i = 1; i < nums.length; i++){  //sums是前面的和加上现在的值.所以,只能从1开始
//                sums[i] = sums[i-1] + nums[i];
//            }
//        }
//
//        public int sumRange(int i, int j) { //i,j与上面sums的索引一致
//            if(i <= 0){
//                return sums[j];
//            } else{
//                return sums[j] - sums[i-1];
//            }
//        }
//    }
    class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            //sums也是从0~n-1的.只不过代表之前到现在值的所有和.
            for(int i = 0; i < nums.length; i++){  //sums是前面的和加上现在的值.所以,只能从1开始,从0开始,0有不同就用条件运算符!!!!!!!!!
                sums[i] = i == 0 ? nums[0] : sums[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) { //i,j与上面sums的索引一致
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
