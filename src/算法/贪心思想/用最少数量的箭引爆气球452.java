package 算法.贪心思想;
//思路:依旧是按尾巴排序
import java.util.Arrays;
import java.util.Comparator;
//这道题目的lambda没有搞懂
public class 用最少数量的箭引爆气球452 {
        public int findMinArrowShots(int[][] points) {
            if(points.length == 0){
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));  //按区间的尾巴排序??lambda表示式不是很理解.
            int index = 1;
            int end = points[0][1];
            for(int i = 1; i < points.length; i++){
                if(points[i][0] <= end){  //注意=也算重合,所以这边只能找头大于end的区间才会加一支箭
                    continue;
                }  //还是头比上一个尾巴小,说明重叠则不管.否则就更换新尾巴,箭+1.
                end = points[i][1];
                index++;

            }
            return index;
        }
}
