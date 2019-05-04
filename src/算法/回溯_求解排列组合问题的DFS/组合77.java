package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合77 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(combine(5, 2).toArray()));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dps(res, new ArrayList<>(), 1, n, k);  //这里不需要标记,都是从头往后面遍历,所以不存在回头,也没有重复
        return res;
    }

    private static void dps(List<List<Integer>> res, ArrayList<Integer> list, int start, int n, int k) {  //start代表开头的第一个数(因为从1开始,数和索引对应),往后遍历会慢慢变大,直到n-k+1作为头.满足可以有k个数,也就是最末端的k个数组合
        if (k == 0) {  //表示还需要0个数
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {  //起始值不回头,所以不用标记.
            list.add(i);
            dps(res, list, i + 1, n, k - 1);  //i+1作为下一个递归的起始值,同时因为添加了i.此时k-1.
            list.remove(list.size() - 1);
        }
    }
}
