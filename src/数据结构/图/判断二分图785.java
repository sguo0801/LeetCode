package 数据结构.图;
//本题现在是DPS做法,第二次遇到用BFS试试.
public class 判断二分图785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            //邻接表是指与当前节点相连的节点,这里按0123的顺序.0与13相连,1与02相连,2与13相连,3与+02相连.
            //看题意,没有自环,就是没有单独的点.??
            //标记默认颜色为0,标记1(优先)和-1;
            int n = graph.length;
            int[] colors = new int[n];  //每个节点标记的颜色.初始默认为0
            for (int i = 0; i < n; i++) {
                if (colors[i] == 0 && !isFeed(i, 1, graph, colors)) {  //如果走过了,直接下一个节点(这题目应该是正常只走一个i就全部标记好,除非有不连通的节点),没走过则看标记为1之后是否有冲突,相当于从根出来的另一个节点.
                    return false;
                }
            }
            return true;
        }

        //DPS查找
        private boolean isFeed(int i, int color, int[][] graph, int[] colors) {
            if (colors[i] != 0) {
                return colors[i] == color;  //看当前被涂的节点是否能满足要求的颜色.
            }

            colors[i] = color;  //标记.
            for (int j : graph[i]) {  //深度遍历找跟i相连的下一个节点,
                if (!isFeed(j, -color, graph, colors)) {  //只要不满足.
                    return false;
                }
                //   return isFeed(j, -color, graph, colors);  //退栈不需要清除标记.##true不需要返回,直到遇到false;
            }
            return true;
        }
    }

}
