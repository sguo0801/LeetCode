package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//题目关键是关于135和45两条斜线的坐标表示,其实是个平行四边形.以棋盘四个顶点作为两个平行四边形的两个顶点,所以长度为2*n-1.
//135斜线数组,对角线的点横纵相同,最后以棋盘左下角为第一个0位置,所以坐标为 n-1-(r-c)
//45斜线数组,对角线的点横纵之和相同,最后以棋盘左上角为第一个0位置,坐标为 r+c 即可.
public class N皇后51 {
    class Solution {
        int n;
        public List<List<String>> solveNQueens(int n) {
            this.n = n;  //方便表示n(行,列,数组长度)
            List<List<String>> res =new ArrayList<>();
            boolean[] col = new boolean[n];
            boolean[] a135 = new boolean[2*n-1];
            boolean[] a45 = new boolean[2*n-1];  //列,135度和45度的标记数组,因为dps中有该参数,所以不用写在外面
            dps(0, col, a135, a45, res, new ArrayList<>());
            return res;
        }

        private void dps(int r, boolean[] col, boolean[] a135, boolean[] a45, List<List<String>> res, ArrayList<String> list){
            if(r == n){  //此时r为上一层的8,现在是r+1=9.所以=n
                res.add(new ArrayList<>(list));  //说明满足则添加
                return;
            }

            for(int c = 0; c < n; c++){  //这里表示的是列,从最左端到最右端.
                if(! col[c] && ! a135[n-1-(r-c)] && ! a45[r+c]){  //行,左斜,右斜,都没有则可以填一个皇后,但是要注意一填要填一行String
                    char[] row = new char[n];  //要填进list中的行.因为list中只能添加String,所以要通过 摆好字符数组 再变成String添加.
                    Arrays.fill(row, '.');
                    row[c] = 'Q';  //第c列,变成Q.则字符数组摆好了
                    col[c] = true;
                    a135[n-1-(r-c)] = true;
                    a45[r+c] = true;  //标记
                    list.add(String.valueOf(row));  //或者list.add(new String(row));
                    dps(r+1, col, a135, a45, res, list);
                    list.remove(list.size()-1);  //回溯,移除最后一行String
                    col[c] = false;
                    a135[n-1-(r-c)] = false;
                    a45[r+c] = false;  //取消标记
                }
            }
        }
    }
}
