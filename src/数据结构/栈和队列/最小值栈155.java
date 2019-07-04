package 数据结构.栈和队列;

import java.util.Stack;

public class 最小值栈155 {
    class MinStack {

        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int min =  Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            dataStack.push(x);
            min = Math.min(min, x);  //这个min不能合到下面去,即不能写成minStack.push(Math.min(min, x));###原因???
            minStack.push(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();  //可能最后min没有值,那就不好再入栈啦,所以要判断一下
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
