package BFS广度优先遍历.DFS深度优先遍历;
//首先对边界上每一个'O'做深度优先搜索，将与其相连的所有'O'改为'-'。然后遍历矩阵，将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'
public class 被围绕的区域130 {
    class Solution {
        int row, col;  //dps要用,写在外面

        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            row = board.length;
            col = board[0].length;
            for (int i = 0; i < row; i++) {
                dps(board, i, 0);
                dps(board, i, col - 1);
            }
            for (int j = 0; j < col; j++) {  //重合四个角也不影响
                dps(board, 0, j);
                dps(board, row - 1, j);  //最外围边框开始dps遍历O.
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '-') {
                        board[i][j] = 'O';
                    }
                }
            }
            return;
        }

        private void dps(char[][] board, int i, int j) {
            if (i < 0 || i >= row || j < 0 || j >= col) {  //加上边界条件判断.
                return;
            }
            if (board[i][j] == 'X') {
                return;
            }
            if (board[i][j] == 'O') {
                board[i][j] = '-';
                dps(board, i + 1, j);
                dps(board, i - 1, j);
                dps(board, i, j + 1);
                dps(board, i, j - 1);
            }
            return;
        }
    }
}
