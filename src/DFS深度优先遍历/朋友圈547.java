package DFS深度优先遍历;

public class 朋友圈547 {
    class Solution {
        int n;

        public int findCircleNum(int[][] M) {
            n = M.length;  //一共n个朋友
            boolean[] isVisited = new boolean[n];  //默认false.
            int circle = 0;
            for(int i = 0; i < n; i++){
                if(! isVisited[i]){
                    dps(M, i, isVisited);  //这里标记数组作为递归的变量,否则就要写在类的外面,但是该数组长度由M的已知长度决定
                    circle++;
                }
            }
            return circle;
        }

        private void dps(int[][] M, int i, boolean[] isVisited){  //开始标记所有相关联的
            isVisited[i] = true;  //标记
            for(int k = 0; k < n; k++){  //找互为朋友的下一个同学,在所有人中,所以有n放在外面
                if(M[i][k] == 1 && (!isVisited[k])){  //有关系且没有被拉进圈子
                    dps(M, k, isVisited);  //延伸找下一个相连的同学
                }
            }
        }
    }
}
