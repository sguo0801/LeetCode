package 算法.贪心思想;
//思路:先安排最高的人,就是按身高降序,如果身高相同则按k升序.
//假设候选队列为 A，已经站好队的队列为 B.
//
//从 A 里挑身高最高的人 x 出来，插入到 B. 因为 B 中每个人的身高都比 x 要高，因此 x 插入的位置，就是看 x 前面应该有多少人就行了。比如 x 前面有 5 个人，那 x 就插入到队列 B 的第 5 个位置。
//// 先排序
//        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
//
//        // 再一个一个插入。
//        // [7,0]
//        // [7,0], [7,1]
//        // [7,0], [6,1], [7,1]
//        // [5,0], [7,0], [6,1], [7,1]
//        // [5,0], [7,0], [5,2], [6,1], [7,1]
//        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//lambda不熟悉啊
public class 根据身高重建队列406 {
        public int[][] reconstructQueue(int[][] people) {
            if(people == null || people.length == 0 || people[0].length == 0){
                return new int[][]{};
            }
            Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));  //0为身高相同按k增大顺序,1也就是k为人数,身高不同按身高降序 这种方式排序.
            //传统比较器方法
//            Arrays.sort(people, new Comparator<int[]>() {  //##泛型为int[],对应compare里面的参数
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//                }
//            });

            //list添加的是int[],所以泛型为int[],不是Integer.
            List<int[]> queue = new ArrayList<>();  //每一个int[]应该是[7, 0]这样的数,p[1]代表k也就是人数.
            for(int[] p : people){
                queue.add(p[1], p); //按照k插入列表中,插的是p.也就是add(index, element).
                //先插入的k=0,可能会在后面.如果后面也有k=0的话.
                //这里queue插入了所有的排序的元素.
            }

            return queue.toArray(new int[queue.size()][0]);  //列表长度为size().最后变成要求的形式就是啦
            //###将queue<int[]>转化为二维矩阵
        }
}
