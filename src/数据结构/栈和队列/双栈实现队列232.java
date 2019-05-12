package 数据结构.栈和队列;

import java.util.Stack;

public class 双栈实现队列232 {
    class MyQueue {

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            change();
            return out.pop();
        }

        /** Get the front element. */
        public int peek() {
            change();
            return out.peek();
        }
        //只有当out为null时才可以从in中转入元素,并且要完全转入
        private void change(){
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.empty() && out.isEmpty();

        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
