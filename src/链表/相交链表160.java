package 链表;

public class 相交链表160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    //当访问A链表的指针访问到链表尾部时，令它从链表B的头部开始访问链表B;同样地，当访问B链表的指针访问到链表尾部时，令它从链表A的头部开始访问链表A.
    //这样就能控制访问A和B两个链表的指针能同时访问到交点。
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            while(a != b){
                a = a == null ? headB : a.next;  //a到尾巴则开始遍历B
                b = b == null ? headA : b.next;
            }
            return a;
        }
    }
}
