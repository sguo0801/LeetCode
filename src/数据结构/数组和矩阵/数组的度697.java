package 数据结构.数组和矩阵;

import java.util.HashMap;
import java.util.Map;

public class 数组的度697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //通过一个map来标记每走过一个数的度和出现的头尾索引.
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {  //需要i所以不能用foreach循环
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[]{1, i, i});  //这里是关键,第一个数是度,后两个分别书起始与终止索引,用来在后面找最小长度.
                } else {
                    int[] temp = map.get(nums[i]);  //先把数值对应的数组找出来
                    temp[0]++;
                    temp[2] = i;
                }
            }

            //现在是找最大度的最小长度子数组,并且返回长度.
            int degree = Integer.MIN_VALUE;
            int length = Integer.MAX_VALUE;
            //遍历map中的int[]数组,因为找与nums相同大小的度,就是各数值中最大的度
            for (int[] temp : map.values()) {
                if (temp[0] > degree) {  //注意要更新degree.
                    degree = temp[0];
                    length = temp[2] - temp[1] + 1;
                } else if (temp[0] == degree) {
                    length = Math.min(length, temp[2] - temp[1] + 1);
                }
            }
            return length;
        }
    }
}
