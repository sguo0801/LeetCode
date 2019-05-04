package 算法.数学;
//相遇问题
//还有先求出中位数的方法,这里时间复杂度不是很懂??
//每次可以对一个数组元素加一或者减一，求最小的改变次数。
//这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：
//设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
//设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
import java.util.Arrays;

public class 最少移动次数462 {
    class Solution {
        public int minMoves2(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int sum = 0;
            Arrays.sort(nums);
            while(l < r){
                sum += nums[r--] - nums[l++];
            }
            return sum;
        }
    }
}
