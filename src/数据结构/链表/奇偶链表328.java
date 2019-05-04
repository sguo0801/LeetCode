package 数据结构.链表;

public class 奇偶链表328 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head != null){  //如果头是null,最后返回head
                ListNode odd = head;
                ListNode even = head.next; //这里是指针节点
                ListNode evenHead = head.next;  //这是偶节点的头

                while(even != null && even.next != null){  //这里是一定是以even为标准,才不会丢掉最后一个节点.
                    odd.next = odd.next.next;
                    even.next = even.next.next;
                    odd = odd.next;
                    even = even.next;  //后移
                }
                odd.next = evenHead;
            }
            return head;
        }
    }
}
