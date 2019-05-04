package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dps(res, new ArrayList<>(), 0, candidates, target);  //0是从数组的第几位开始往list中添加,这里可以重复则从0开始,并且不回头.无需添加标记.
            return res;
        }

        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int[] candidates, int target){
            if(target == 0){
                res.add(new ArrayList<>(list));

            }

            for(int i = start; i < candidates.length; i++){  //i可以以最后一个元素为起点
                if(candidates[i] <= target){
                    list.add(candidates[i]);
                    dps(res, list, i, candidates, target-candidates[i]); //因为可以重复所以从当前i开始遍历,否则就得从i+1找后面的组合元素,而且target要进行更新.
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
