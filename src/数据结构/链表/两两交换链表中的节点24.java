package 数据结构.链表;

public class 两两交换链表中的节点24 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode n = head.next; //next出现在=右边,代表赋值,此时n就是head的下一个节点,值为2
            head.next = swapPairs(head.next.next);
            n.next = head;   //next在=左边,说明指针指向=右边,一般是进行交换反向插入删除等操作
            return n;
        }
    }
}
