package 数据结构.链表;
//回文链表思路就是先找到右链head,然后反转有链,俩链同时从头进行比较
public class 回文链表234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {  //## 是&&的关系
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null) {
                slow = slow.next;  //是让右边更短啦.
            }

            slow = reverse(slow);  //整个右链反转,slow 从新链的末尾变成新链的头.
            fast = head;

            while (slow != null) {
                if (fast.val != slow.val) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {  //一般操作指针都要有两个新节点.
            ListNode temp = null;
            while (head != null) {
                ListNode node = head.next;  //先把下一个节点保存.
                head.next = temp;
                temp = head;
                head = node;  //这边不需要node.next = head.下一个循环自然会有连接.
            }
            return temp;  //此时head已经为null.
        }
    }
}
