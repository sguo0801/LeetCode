package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 求有重复数字集合的子集90 {
    class Solution {
        //脑海思路:1.不回头所以不需要标记 2.有重复元素解集不能重复,则要排序,且i>start,进行去重,且i+1为新start.
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            dps(res, new ArrayList<>(), 0, nums);  //没有要求和之类的所以少一个参数k,这里是索引,所以从0开始.
            return res;
        }

        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int[] nums){
            res.add(new ArrayList<>(list));  //最先填进去子集的空集
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]){  //因为不回头,然后去重就用i>start
                    continue;
                }
                list.add(nums[i]);
                dps(res, list, i+1, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
