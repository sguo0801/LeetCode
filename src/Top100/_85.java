package Top100;
import java.util.Stack;
//时间复杂度：O（mn）。
//
//空间复杂度：O（n）。
//解法与84一致,就是每一行,从上到下.比如第二行,先看第二行的数,看上面的1,就是柱子,如果是0,则就是空,无论0的上面有没有1,那不是当前行的事,是前几行的事.解法同84,运用栈.
public class _85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            //找每一行的柱子.
            //每到新的一行i,则重新遍历高度值.遍历一行就是j从0到n.
            if(matrix.length == 0){   //注意边界条件,否则matrix[0]不存在,则n可能越界.
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[] height = new int[n];  //要自己创造高度数组.其中的值每一行都不一样.
            int area = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);  //同84题一样的-1.
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;  //新的一行值为1,则在原来基础上+1,否则柱子断裂.
                    //现在数组中的值有啦.开始计算面积,正好i确定时,每过一个j,就确定下一个数组中值.也就是说,这里的遍历j就是84题的遍历i.
                    while(stack.peek() != -1 && height[j] < height[stack.peek()]){  //##记住栈中都是索引,而且都是往回看,所以索引都是当前行的
                        area = Math.max(area, height[stack.pop()] * (j - (stack.peek() + 1)));
                    }
                    stack.push(j);
                }
                //这里还是当前行,只不过j遍历完毕,下面处理当前栈中的值.
                while(stack.peek() != -1){
                    area = Math.max(area, height[stack.pop()] * (n - (stack.peek() + 1)));
                }
            }
            return area;
        }
    }
}
