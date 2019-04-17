import java.util.LinkedList;
import java.util.Queue;

public class 最短路径长度 {
    public static void main(String[] args){
        int[][] a = {{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1},{1, 0, 1, 1}};
        System.out.println(minPathLength(a, 3, 3));
    }
    public static int minPathLength(int[][] grids, int tr, int tc){
        final int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  //下上右左四个方向.是个四行两列的矩阵.
        Queue<Position> queue = new LinkedList<>();
        int m = grids.length;
        int n = grids[0].length;
        queue.offer(new Position(0, 0, 0));  //初始值length有待商榷,但是不影响流程,从左上角开始!返回的是6.应该是没有问题
        while (! queue.isEmpty()){  //只要还有一个位置可以选.
            Position nowPos = queue.poll(); //保存下当前的作为后面的新位置来源
            for (int i = 0; i < 4; i++){  //四个方向开始挨个试.
                Position nextPos = new Position(nowPos.r + next[i][0], nowPos.c + next[i][1], nowPos.length + 1);//这里是四个方向,i0,i1作为行列的增量.
                if(nextPos.r < 0 || nextPos.r >= m || nextPos.c < 0 || nextPos.c >= n){
                    continue;  //如果撞墙啦,则换方向继续换方位.
                }
                if(grids[nextPos.r][nextPos.c] != 1){
                    continue;  //如果当前试探的位置不为1,即不能走.继续换方位
                }
                grids[nextPos.r][nextPos.c] = 0; //确认走到当前位置,然后置0防止后面再走到这个位置.
                if(nextPos.r == tr && nextPos.c == tc){  //如果试探的点是想达到的位置,那么就返回长度.
                    return nextPos.length;
                }
                queue.offer(nextPos);  //如果不是当前的点,先放到queue中作为下一次可能延伸的源头.
            }
        }
        return -1; //说明达到不了该点.

    }


}
 class Position{
    int r;  //修饰符不能用私有.其他类会无法调用,可以全部用默认.
    int c;
    int length;
    Position(int r, int c, int length){  //当前位置的行,竖,到当前位置的路径长度.
        this.r = r;
        this.c = c;
        this.length = length;
    }
}
