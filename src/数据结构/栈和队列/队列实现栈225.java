package 数据结构.栈和队列;

import java.util.LinkedList;
import java.util.Queue;
//在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，需要让 x 插入队列首部。而队列的默认插入顺序是队列尾部，
// 因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。
public class 队列实现栈225 {
    class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            int sum = queue.size();
            while(sum-- > 1){  //就是把除了当前插入元素的其他元素都放回新插入元素的后面,这里是变成栈的关键
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();  //###pop()与poll类似.poll最后可以返回null,而且poll()是Queue的方法.更好用.
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
