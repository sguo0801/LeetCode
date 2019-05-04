package 链表;

import java.util.Stack;

public class 两数相加445 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null) {
                s1.push(l1.val);  //栈内存的是值
                l1 = l1.next;
            }
            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
            ListNode tail = null;  //作为尾巴.
            //两个栈逆序,小的在栈顶
            int temp = 0;  //溢出位的值,就是1或者0
            while (!s1.isEmpty() || !s2.isEmpty() || temp != 0) {
                int x = s1.isEmpty() ? 0 : s1.pop();
                int y = s2.isEmpty() ? 0 : s2.pop();
                temp += x + y;
                ListNode node = new ListNode(temp % 10);
                node.next = tail;  //最初的节点后面是null
                tail = node; //前移.
                temp /= 10;
            }
            return tail;
        }
    }
}
