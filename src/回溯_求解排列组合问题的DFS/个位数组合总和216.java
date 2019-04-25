package 回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.List;

public class 个位数组合总和216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            dps(res, new ArrayList<>(), 1, k, n);
            return res;
        }

        private void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int k, int n){
            if(k == 0 && n == 0){
                res.add(new ArrayList<>(list));
                return;
            }

            for(int i = start; i < 10; i++){
                list.add(i);
                dps(res, list, i+1, k-1, n-i);
                list.remove(list.size()-1);
            }
        }
    }
}
