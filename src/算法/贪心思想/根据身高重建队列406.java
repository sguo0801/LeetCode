package 算法.贪心思想;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//lambda不熟悉啊
public class 根据身高重建队列406 {
        public int[][] reconstructQueue(int[][] people) {
            if(people.length == 0 || people == null || people[0].length == 0){
                return new int[][]{};
            }
            Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));  //0为身高相同按k增大顺序,1也就是k为人数,身高不同按身高降序 这种方式排序.

            List<int[]> queue = new ArrayList<>();  //每一个int[]应该是[7, 0]这样的数,p[1]代表k也就是位数.
            for(int[] p : people){
                queue.add(p[1], p); //按照k插入列表中,插的是p.
            }

            return queue.toArray(new int[queue.size()][0]);  //列表长度为size().最后变成要求的形式就是啦
        }
}
