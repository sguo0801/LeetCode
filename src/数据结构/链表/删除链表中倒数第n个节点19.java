package 数据结构.链表;

public class 删除链表中倒数第n个节点19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while(n-- > 0){  //找到fast与slow的距离,再一起走.
                fast = fast.next;
            }
            if(fast == null){
                return head.next;  //表示一共就n个节点.,倒数第n个,就是把第一个去掉
            }
            ListNode slow = head;
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;  //定位到被删节点之前,开始删除
            return head;
        }
    }
}
