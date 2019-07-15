package Top100;
//时间复杂度：O(n\log{}n)O(nlogn)
//
//除去 sort 的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlgn)O(nlgn)
//
//空间复杂度：O(1)O(1) (or O(n)O(n))
//
//如果我们可以原地排序 intervals ，就不需要额外的存储空间；否则，我们就需要一个线性大小的空间去存储 intervals 的备份，来完成排序过程。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//合并区间,这里是 按左端点排序,这样就只需要照看右边合并即可
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
                    newInter[1] = Math.max(newInter[1], interval[1]);  //已经添加了,在原基础上改
                }else{
                    newInter = interval;  //同一变量不会重叠?区间如果改掉一边端点则就是新的变量?
                    list.add(newInter);  //同一变量进行添加

                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
