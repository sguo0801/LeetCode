package 算法.回溯_求解排列组合问题的DFS;
//定义好四个方向,,先找到入口,再进行递归,注意标记字符可以用^.
public class 单词搜索79 {
    class Solution {
        private int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  //下上右左,方向迭代.二维矩阵是大括号,中括号是list<int[]>
        int m, n;  //作为dps的边界
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(dps(board, word, i, j, 0)){  //从这里开始的都是放进去第一个字母,但是还没有确认是不是符合要求的头.num指下一个要匹配的字符在word中的位置.
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dps(char[][] board, String word, int i, int j, int num){
            if(num == word.length()){
                return true;  //递归的终止条件
            }
            if(i < 0 || i == m || j < 0 || j == n || (board[i][j] != word.charAt(num))){  //注意别马虎,board[i][j].word.charAt()不是中括号.
                return false;
            }
            board[i][j] ^= 256;//与word匹配,开始标记,100000000,可以把0~255的字符,变成256+.
            for(int[] d : next){
                if(dps(board, word, i+d[0], j+d[1], num+1)){  //后面如果也匹配上,则这里也可以暂时匹配.直到再后面不符合再递归回来
                    return true;
                }
            }
            board[i][j] ^= 256;  //取消标记,开始回溯.
            return false;
        }
    }
}
