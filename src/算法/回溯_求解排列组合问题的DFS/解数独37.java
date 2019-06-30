package 算法.回溯_求解排列组合问题的DFS;

//关键是方框索引的地方i / 3 * 3 + j / 3.取整数很关键,不要随便把两个3约掉!!!!
//用i来找到方框的行首(0,3,6)然后用j来做偏移进行加和.
public class 解数独37 {
    class Solution {
        boolean[][] row = new boolean[9][10]; //前面是行数,0~8,后面是是否存在num,1~9,没有0,只表示存在这个数与否.不从0开始表示更方便.
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];  //前面是9个方框.

        public void solveSudoku(char[][] board) {
            int num;
            //先要遍历数独,找到所有非'.'的格子,标记好三个数组
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        num = board[i][j] - '0';  //##
                        row[i][num] = true;  //代表这个数存在于这个一行中
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            dps(board, row, col, block, 0, 0);  //后面的0,0代表以最左上方为头,开始递归.
        }

        private boolean dps(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
            while (board[i][j] != '.') {//这里也是截止条件.跳过非'.'的格子,如果是当行最后一个数,则下移动一行,如果是最后一行最后的一个数,则返回true.
                if (++j >= 9) {  //这里++j,是因为当前为数字,自动向右移动一位,如果不是此行最后一个数,跳过,如果是最后一个数则到下一行第一个数
                    i++;
                    j = 0;  //到下一行第一个数.
                }
                if (i >= 9) {
                    return true;
                }
            }
            //这里是发现是空的'.',开始进行填数,但是必须保证当前行列方框都没有此数才能进行填充.
            for (int num = 1; num <= 9; num++) {
                if (!row[i][num] && !col[j][num] && !block[i / 3 * 3 + j / 3][num]) {  //此处为'.',但是要注意行,列,框都不能有这个数进行遍历num,注意是&&!!
                    board[i][j] = (char) ('0' + num);  //##从1开始赋值,注意进行强转从int变char,而且是以'0'为基准!!!!
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i / 3 * 3 + j / 3][num] = true;  //这三行是标记.说明填好了
                    if (dps(board, row, col, block, i, j)) {  //可以从当前位置继续递归,因为后面dps检查,已经不为空,则会进行后移操作,这里不需要管
                        return true;  //后面有解,则说明填对,直接跳出
                    }
                    //这里是回溯,取消标记,并且变回'.',等待num更新再填入.
                    board[i][j] = '.';
                    row[i][num] = false;
                    col[j][num] = false;
                    block[i / 3 * 3 + j / 3][num] = false;
                }
            }
            //发现当前位置填什么数字都不行,则回溯到上一层,说明之前有填错的数
            return false;
        }
    }
}
