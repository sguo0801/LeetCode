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
    //思路:直接指定偶数节点头.分别进行后移,注意指针节点从第二个开始,最后连接.
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head != null){  //如果头是null,最后返回head##必须看好边界条件.
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
            return head;  //##注意返回head,不是odd
        }
    }
}
