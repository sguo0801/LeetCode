package 算法.DFS深度优先遍历;
//就是DFS进行标记.注意岛屿的类型char和int区分.
public class 岛屿的个数200 {
    class Solution {
        private int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  //方向
        int m, n;
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            m = grid.length;
            n = grid[0].length;
            int num = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){   //以i,j坐标为起始的起始遍历点.
                        dps(grid, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        private void dps(char[][] grid, int i, int j){
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){  //有必要进行边界限制
                return;
            }
            grid[i][j] = '0'; //标记
            for(int[] d : next){
                dps(grid, i+d[0], j+d[1]);  //延伸该岛屿并进行后面的标记
            }
        }
    }
}
