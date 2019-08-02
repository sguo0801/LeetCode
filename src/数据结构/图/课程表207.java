package 数据结构.图;
//拓扑排序只用bfs即可,无论判断还是输出排序.
import java.util.ArrayList;
// #####本题用bfs会更好.//#####跟210一样,只不过order索引如果不满足课程和,就说明有每天加进来的,即有环.则不存在
public class 课程表207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //通过dfs去做,
            // #####当然本题用bfs会更好.//#####跟210一样,只不过order索引如果不满足课程和,就说明有每天加进来的,即有环.则不存在
            //graph作为先决课程的数组,每个格子内,是受控制的科目(即索引为先决课程).完成索引,格子内则可能完成.
            //只要访问格子内的课程发现以该课程在graph中找需要已经标记的先决课程,则形成环.不可能完成所有.
            //先让一个先决课程完成,然后遍历其控制的课程,如果还需要之前的先决课程,则有环即不能完成.
            ArrayList[] graph = new ArrayList[numCourses];   //###这边是数组内放list,所以必须类型改成List
            for (int i = 0; i < numCourses; i++) {  //##先做好列表.
                graph[i] = new ArrayList<Integer>();
            }
            boolean[] visits = new boolean[numCourses];  //标记数组
            for (int i = 0; i < prerequisites.length; i++) {  //开始填充graph数组,以prere来遍历
                // graph[i] = new ArrayList<Integer>();  //??pre和graph长度不同
                graph[prerequisites[i][1]].add(prerequisites[i][0]);  //1指的是先决课程,也就是graph的索引,0指的是受控课程.这道题目后面是先决课程,即1

            }

            for (int i = 0; i < graph.length; i++) {  //看graph数组内是否有环
                if (!dps(graph, visits, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dps(ArrayList[] graph, boolean[] visits, int i) {
            if (visits[i]) {
                return false;  //已经标记啦,就返回false,说明有环.
            }
            visits[i] = true;  //开始标记
            for (int j = 0; j < graph[i].size(); j++) {   //开始遍历由i先决的受控课程
                if (!dps(graph, visits, (int) graph[i].get(j))) {  //##取到的是Object类型.注意强转
                    return false;
                }
            }
            visits[i] = false;  //###取消标记,是可能该课程不需要最先做,可以先取消标记等后面的课程再遍历到这里,就是需要回头.可能上层不行,但是继续遍历这边下层的课程要取消标记.
            return true;  //说明以此时的graph[i]课程为先决是没有环的,进入下一个课程.
        }
    }
}
