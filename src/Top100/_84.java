package Top100;
//柱状图:https://blog.csdn.net/Zolewit/article/details/88863970,关于索引+1的内容,博客内是栈放入高度.本文是放入索引就可以不考虑栈空情况.
//中文题解,包括code中最优法可以再看一下https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
import java.util.Stack;

public class _84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);  //为了最后把所有数组中的值弹出来.在图中这个-1的右下是第一个索引0,所以,当最后一个数弹出栈,栈中只有-1;作为求宽的左边界,比如2.1.2,第一次左边的2弹出,最后算1的面积,应该为3=length-(-1+1),-1为peek(),面积不是2.所以两种while的求面积方法一致.
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                //如果当前数小于栈顶,则就弹出栈顶,求包含该高度的对应的最大面积.只要有i就会压栈,所以while里看是否栈顶大.
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {   //第一次肯定要放索引,不需要跟-1比较,这边如果与栈顶相等不急着算.比如1,1.两个的面积都是2才对.
                    area = Math.max(area, heights[stack.pop()] * (i - (stack.peek() + 1)));//这边先弹出,且索引+1,看博客
                }
                stack.push(i);  //我栈内放的是索引,方便后面求遍历数组后栈中剩余的面积,当然放高度也可以看博客.
            }
            //已经都入栈啦,现在栈中剩下的肯定是递增的高度.则能包含的每一个最大面积的宽就是,最大长度-索引.
            while (stack.peek() != -1) {
                area = Math.max(area, heights[stack.pop()] * (heights.length - (stack.peek() + 1)));   //这里要先弹出,要用到-1.抵消掉+1.
            }
            return area;
        }
    }
}
