package 动态规划.最长递增子序列;

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
