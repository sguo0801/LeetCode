package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//合并区间
public class _56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //思路还是按区间左端点排序,然后看第二个区间的头与第一个区间的尾,作比较.
            //先建立一个list,然后添加新区间,如果区间有重叠,则在list中的区间上更改,直到下一个非间隔,再在list中建立新的区间
            //最后将list转成二维矩阵,就是toArray.变量是矩阵的行数.

            if(intervals.length <= 1){
                return intervals;
            }
            //按头排序.直接lambda比较器.不需要foreach,直接是其中任取两个变量进行比较器比较

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            //也可以写成Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


            List<int[]> list = new ArrayList<int[]>();
            int[] newInter = intervals[0];
            list.add(newInter);
            for(int[] interval : intervals){
                if(interval[0] <= newInter[1]){
                    newInter[1] = Math.max(newInter[1], interval[1]);
                }else{
                    newInter = interval;  //同一变量不会重叠?区间如果改掉一边端点则就是新的变量?
                    list.add(newInter);

                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
