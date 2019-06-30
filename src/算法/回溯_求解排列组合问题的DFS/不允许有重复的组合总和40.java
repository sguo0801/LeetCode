package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//关于不重复的问题,两种方法,一种在满足条件时,看res中是否包含,这种写起来简单,不需要boolean数组,也不需要在循环中考虑与前一个相同的情况,但是时间空间复杂度比较高,
//第二种是采用boolean数组,并且在循环中判断与前一个数相等的情况(之前有排序),如果前一个没有标记,说明当前的排列之前已经发生过,直接跳过.想想112.第二个1做开头的情况
//第三种,不需要采用boolean数组,在循环中,因为不回头,只要i>start且当前值与前一个相等,则继续遍历下一个i,只要不回头其实就可以不进行标记.
public class 不允许有重复的组合总和40 {
    class Solution {
        //        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//            List<List<Integer>> res = new ArrayList<>();
//            Arrays.算法.sort(candidates);  //必不可少的排序
//            boolean[] arr = new boolean[candidates.length];
//            dps(res, new ArrayList<>(), 0, arr, candidates, target);
//            return res;
//        }
//
//        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, boolean[] arr, int[] candidates, int target){
//            if(target == 0){
//                //    if(!res.contains(list))
//                res.add(new ArrayList<>(list));
//                return;
//            }
//
//            for(int i = start; i < candidates.length; i++){
//                if(i != start && candidates[i] == candidates[i-1] && !arr[i-1]){ //
//                    continue;
//                }
//                if(candidates[i] <= target){
//                    arr[i] = true;
//                    list.add(candidates[i]);
//                    dps(res, list, i+1, arr, candidates, target-candidates[i]); //从i+1开始,因为不能重复,而且也不回头,所以不需要标记.##记得更新target!!!!!!!
//                    list.remove(list.size()-1);
//                    arr[i] = false;
//                }
//            }
//        }
//    }
//第三种方法!不进行标记的最有做法!!!
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            //  boolean[] arr = new boolean[candidates.length];
            dps(res, new ArrayList<>(), 0, candidates, target);
            return res;
        }

        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int[] candidates, int target) {
            if (target == 0) {
                //    if(!res.contains(list))
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {  //不回头根本不需要标记.记得排序,找相同排除
                    continue;
                }
                if (candidates[i] <= target) {
                    //arr[i] = true;
                    list.add(candidates[i]);
                    dps(res, list, i + 1, candidates, target - candidates[i]); //从i+1开始,因为不能重复,而且也不回头,所以不需要标记.##记得更新target!!!!!!!
                    list.remove(list.size() - 1);
                    //arr[i] = false;
                }
            }
        }
    }
}
