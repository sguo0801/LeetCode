package 算法.数学.其他;

import java.util.Arrays;

//思路分析： 对于如果使三个数乘积达到最大，大家都会想到将三个值都取到最大即可，
//还有一种情况就是两个最小的负数和最大的正数也可能达到最大值。
//方法一：先将数组进行升序排序，然后找出上述的两种情况取较大值。（时间复杂度O(nlog2 n)，额外空间复杂度O(1)）
//方法二：扫描数组，直接确定上面两种情况需要的五个值。（时间复杂度O(n)，额外空间复杂度O(1)）
public class 三个数的最大乘积628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            if(nums.length < 3){
                return 0;
            }
            if(nums.length == 3){
                return nums[0] * nums[1] * nums[2];
            }
            Arrays.sort(nums);
            int max = Integer.MIN_VALUE; //int中的最小值
            if(nums[0] < 0 && nums[1] < 0){
                max = nums[0] * nums[1] * nums[nums.length-1];
            }

            if(nums[nums.length-1] * nums[nums.length-2]*nums[nums.length-3] > max){
                max = nums[nums.length-1] * nums[nums.length-2]*nums[nums.length-3];
            }
            return max;
        }
    }

    //法二见源头代码
}
