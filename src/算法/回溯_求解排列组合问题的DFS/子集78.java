package 回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//子集就是组合的概念,所以不需要回头,知识要所有的解而已,所以从头加到尾,并且不会重复出现一个值,所以是i+1更新start.如果题目有重复值,还需要进行排序,此题没有重复的数值,所以不需要.
public class 子集78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // Arrays.sort(nums);  题目没有重复则不需要排序.
            dps(res, new ArrayList<>(), 0, nums);
            return res;
        }

        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int[] nums) {  //只有个位数题目为1开始,因为1~9,其他都是索引,从0开始.
            res.add(new ArrayList<>(list));  //第一次可以添加个空集,求子集也是组合的一种,所以不需要标记
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                dps(res, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
