package 算法.贪心思想;

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间435 {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
        public int eraseOverlapIntervals(Interval[] intervals) {
            if(intervals == null || intervals.length == 0){
                return 0;
            }
            Arrays.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval o1, Interval o2){
                    return o1.end - o2.end;  //按照尾部从小到大排序interval数组.
                }
            });

            int index = 1;  //作为最后保留的区间数量,最开始就有一个,也就是intervals[0].
            int end = intervals[0].end; //全场最小的end.可能start不是最小,但是保证end最小即有最多的区间数,因为即便有区间start小,但是end大,没有end小的区间保留的多.
            for(Interval o : intervals){  //注意这里遍历了第一个元素,但是不影响,因为同一个区间start肯定小于end.但是其他题目要注意
                if(o.start < end){
                    continue;
                }else{
                    end = o.end; //更新end.
                    index++;
                }
            }
            return intervals.length - index;  //所有区间数量-最后保留的区间=拿走的区间
        }
}
