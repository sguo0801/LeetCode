package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 无重复排列的全排列47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] arr = new boolean[nums.length];
            Arrays.sort(nums); //要排序才可以
            dps(res, new ArrayList<>(), arr, nums);  //新建的变量可以是默认的ArrayList<>(),但是要有().
            return res;
        }

        public void dps(List<List<Integer>> res, ArrayList<Integer> list, boolean[] arr, int[] nums){  //ArrayList<Integer>作为参量里面的要写全
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }

            for(int i = 0; i < nums.length; i++){  //每次进行下一个位置的填充,都是从头遍历
                if(arr[i]){  //标记说明之前有用过,向后继续遍历.
                    continue;
                }
                if(i != 0 && nums[i] == nums[i-1] && ! arr[i-1]){  //如果前一个相同的数没有标记,即没有走过,说明在之前的排列中,这两个相同的数必然已经组合过.例如:1,1,2,这里前两个1,在第二轮循环是i=1,但是在第一轮已经有过11开头的排列组合啦.注意并不是把相同的数字去掉,而是不能有重复的排列,并不是不能有重复的数字.
                    continue;//这里相同去重的关键在于,如果前一个相同的数没有标记,这说明之前标记过,就跳过.如果之前的数有标记,则是第一次遇到这个数,即便相同也要加上.
                }
                //没有特殊情况,开始标记
                arr[i] = true;
                list.add(nums[i]);
                dps(res, list, arr, nums);
                list.remove(list.size()-1);
                arr[i] = false;
            }
        }
    }
}
