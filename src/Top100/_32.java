package Top100;
//https://leetcode-cn.com/problems/longest-valid-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-7/动态规划可以再看看.
import java.util.Stack;
//有关括号的题目,想想栈,(则入栈,)则出栈,再根据题意判断
public class _32 {
    class Solution {
        public int longestValidParentheses(String s) {
            //遇到左括号,则入栈,否则出栈,出栈后要看是否栈为空,空则把当前位置入栈,说明该位置没有匹配到左括号.不为空则说明匹配可以计算max
            Stack<Integer> stack = new Stack<>();
            stack.push(-1); //为了计算方便.
            int max = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(i);
                }else{
                    stack.pop();
                    if(stack.empty()){
                        stack.push(i);
                    }else{  //匹配到啦,更新max
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }
    }
}
