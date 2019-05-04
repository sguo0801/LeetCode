package 数据结构.链表;

public class 反转链表206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    //递归要注意前面的边界条件
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {  //注意head与下一个是否为空
                return head;
            }
            ListNode next = head.next;
            ListNode cur = reverseList(next);
            next.next = head;
            head.next = null;

            return cur;
        }
    }
    //迭代.
    //class Solution {
    //    public ListNode reverseList(ListNode head) {
    //        ListNode cur = null;
    //        while(head != null){
    //            ListNode next = head.next;
    //            head.next = cur;
    //            //next.next = head; 没有这个连接.
    //            cur = head;
    //            head = next;
    //
    //        }
    //        return cur;
    //    }
    //}
}
