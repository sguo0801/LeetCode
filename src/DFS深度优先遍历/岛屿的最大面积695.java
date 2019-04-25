package DFS深度优先遍历;

public class 岛屿的最大面积695 {
    class Solution {
        final int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  //下上右左四个方向
        int m, n;  //这两个写在前面.

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int area = 0;
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    area = Math.max(area, dps(grid, i, j));  //比较以i,j为起点的深度遍历的最大值,因为前面遍历过会置0,所以不必担心会重复.
                }
            }
            return area;
        }

        public int dps(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;  //代表走过,标记
            int area = 1;  //起点符合要求初始一块岛屿
            for (int[] d : next) {  //对二维数组做foreach循环,元素为一维数组.
                area += dps(grid, i + d[0], j + d[1]);  //递归进行延伸并且增加岛屿面积.
            }
            return area;
        }
    }
}
