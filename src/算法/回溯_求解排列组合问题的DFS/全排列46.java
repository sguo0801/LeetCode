package 算法.回溯_求解排列组合问题的DFS;
//leetcode中首赞有所有题型的答案.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列46 {
        public static void main(String[] args){
            int[] a = {1, 2, 3};
            System.out.println(Arrays.toString(permute(a).toArray()));  //Arrays.toString将数组转为string,....toArray()是将列表中的值输出为数组.;也可以直接输出列表.一样的!!!
        }
        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] arr = new boolean[nums.length];
            dps(res, new ArrayList<>(), arr, nums);
            return res;
        }

        private static void dps(List<List<Integer>> res, List<Integer> list, boolean[] arr, int[] nums) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));  //###因为直接加入list的话加入的是引用，后序对list的操作会影响到res里面的list的内容，所以是要对list进行深拷贝，然后再加入res,所以要重新new一个ArrayList,把list此时的值复制进去.
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (arr[i]) {
                    continue;
                }
                arr[i] = true;  //只要之前没用过,此时标记,并且添加进list.
                list.add(nums[i]);
                dps(res, list, arr, nums);
                list.remove(list.size() - 1);
                arr[i] = false;  //取消标记.
            }

        }
}
