package 数据结构.图;
//https://blog.csdn.net/dm_vincent/article/details/7714519  可以再次做到拓扑排序的时候看一下

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//这题目用的bfs,比dfs要快很多.最主要这里要把课程顺序找出来,所以当先决课程为0,则把对应的受控课程放入队列中,队列在放入排序数组返回.依次以这个课程为先决课程的limit中对应索引的值减少
//dfs是一个标记数组,这里是一个int数组进行数量动态更新.
public class 课程表的顺序210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //采用bfs进行求解.类比之前的课程表,依然要先把有向图graph做出来,索引是先决课程1,列表中是受该先决课程影响的课程0.
            //bfs需要用一个数组limit表示每门课先决课程的数量,在bfs时,先决课程为0的,先要放在queue中,作为先访问的课程
            //先访问的课程如果是其他课程的先决,被访问后则在limit中应该在对应其他课程上减少先决的数量.当先决为0时,添加进offer.

            //先做好有向图graph.然后在中间做好limit数组.
            ArrayList[] graph = new ArrayList[numCourses];   //这里graph用ArrayList<<ArrayList<>>(),也可以.
            for (int i = 0; i < numCourses; i++) {  //先让数组连接list
                graph[i] = new ArrayList<Integer>();  //先把数组中填充空白列表
            }

            int[] limit = new int[numCourses];  //limit先决课程数量
            for (int[] pre : prerequisites) {  //填充列表,并且把受控课程的先决数量标记清楚.
                graph[pre[1]].add(pre[0]);
                limit[pre[0]]++;    //这边是受控课程对应数量+1.受控对应pre前面的0位
            }

            return bfs(graph, limit);  //不需要像dfs以i为头进行递归
        }

        private int[] bfs(ArrayList[] graph, int[] limit) {
            int[] order = new int[graph.length];  //要返回的排序数组
            Queue<Integer> queue = new ArrayDeque<>();   //双端队列ArrayDeque
            //先把先决课程数量为0的填进queue中,作为层遍历的起始.也就是受控课程对应限制值为0的
            for (int i = 0; i < limit.length; i++) {
                if (limit[i] == 0) {
                    queue.offer(i);
                }
            }
            //这种课程表题目的bfs只用一次while,因为不需要分层,每个节点(先决课程数量)都是动态变化的,直接往queue加即可.而且如果加不进来也没关系,最后会返回空数组.
            int index = 0;    //order数组的索引.
            while (!queue.isEmpty()) {
                int head = queue.poll();  //开始访问
                order[index++] = head;    //##放进答案数组中,不是limit,别混咯

                //更新先决课程数量,并把更新后为数量0的放入queue中.
                for (int i = 0; i < graph[head].size(); i++) {   // graph[head]中是被head影响的课程temp;
                    int temp = (int) graph[head].get(i); // ##注意要强转成int,并且ArrayList不能被强转,必须得get;如果graph用List<<>>,是可以直接用graph.get(head)进行foreach的.
                    limit[temp]--;
                    if (limit[temp] == 0) {   //
                        // 影响temp的先决课程为0个,则可以上temp课
                        queue.offer(temp);
                    }
                }
            }

            return index == limit.length ? order : new int[]{};  //或者new int[0]; //##左边不要写成order.length,这样是定值.
        }
    }
}
