package 算法.动态规划.最长递增子序列;
//如果 nums[i] > nums[i-1]nums[i]>nums[i−1] ，意味着这里在摆动上升，前一个数字肯定处于下降的位置。所以 up[i] = down[i-1] + 1up[i]=down[i−1]+1 ， down[i]down[i] 与 down[i-1]down[i−1] 保持相同。
//
//如果 nums[i] < nums[i-1]nums[i]<nums[i−1] ，意味着这里在摆动下降，前一个数字肯定处于下降的位置。所以 down[i] = up[i-1] + 1down[i]=up[i−1]+1 ， up[i]up[i] 与 up[i-1]up[i−1] 保持不变。
//
//如果 nums[i] == nums[i-1]nums[i]==nums[i−1] ，意味着这个元素不会改变任何东西因为它没有摆动。所以 down[i]down[i] 与 up[i]up[i] 与 down[i-1]down[i−1] 和 up[i-1]up[i−1] 都分别保持不变。
//
//最后，我们可以将 up[length-1]up[length−1] 和 down[length-1]down[length−1] 中的较大值作为问题的答案，其中 lengthlength 是给定数组中的元素数目。
public class 摆动序列376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {  //没有2 的情况,可能两个数相同!!
            return 1;
        }
        int up = 1, down = 1;  //初始第一个元素就默认长度为一,第一个元素的前面无所谓正负
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;  //如果down不变,即便递增序列,up也不会增加.摆动序列的长度也不会变,只有出现down的变化才可以.中间相当于排除掉.
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;  //从up的基础上+1,相当于出现负值差,开始增加了摆动序列的长度.两个交替才能使长度+1,相等不管,直接看下一个
            }
        }
        return Math.max(up, down);
    }
}
