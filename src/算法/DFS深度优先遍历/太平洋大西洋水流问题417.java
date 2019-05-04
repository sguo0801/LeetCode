package 算法.DFS深度优先遍历;

import java.util.ArrayList;
import java.util.List;
//逆向思维。
// * 先把靠着太平洋的两条边找能到太平洋的水。
// * 再把靠着大西洋的两条边找到能到大西洋的水。
// * 然后往依次遍历,找到都能到的交集点.即为所求
public class 太平洋大西洋水流问题417 {
    class Solution {
        int m, n;  //DFS,会提出来mn作为边界条件.
        int[][] matrix; //DFS的边界条件
        int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  //方向
        public List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> res = new ArrayList<>();
            if(matrix == null || matrix.length == 0){
                return res;
            }
            m = matrix.length;
            n = matrix[0].length;
            boolean[][] reachT = new boolean[m][n]; //判断每个点是否能到达太平洋,标记矩阵.
            boolean[][] reachD = new boolean[m][n]; //判断每个点能否到达大西洋.
            this.matrix = matrix;  //三个值作为类变量共有,这里赋值完毕.
            for(int i = 0; i < m; i++){  //从四个边框开始向中心循环递归进行标记.
                dps(reachT, i, 0);  //左边界开始看到太平洋.因为紧挨着
                dps(reachD, i, n-1);
            }
            for(int i = 0; i < n; i++){
                dps(reachT, 0, i);
                dps(reachD, m-1, i);  //小心马虎##
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(reachT[i][j] && reachD[i][j]){
                        res.add(new int[]{i, j});  //添加新的两边交集的元素
                    }
                }
            }
            return res;
        }

        private void dps(boolean[][] reach, int i, int j){  //标记得方法
            if(reach[i][j]){  //为true,说明标记过了,直接跳过该点,因为这个点后面的也都遍历过了
                return;
            }
            reach[i][j] = true; //第一次遍历,开始标记.能到说明满足要求,开始是边界点,后面是满足大小关系.
            for(int[] d : next){
                int r = i+d[0];
                int c = j+d[1];
                if(r < 0 || r >= m || c < 0 || c >= n || matrix[i][j] > matrix[r][c]){  //不满足漂流条件,注意这里的变量都是类变量
                    continue;  //不满足则换方向继续循环.##
                }
                dps(reach, r, c);  //满足则继续向后延伸深度遍历.
            }
        }
    }
}
