package 算法.Twozhizhen;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//注意要先判断一个和没有节点的情况.然后保证有fast(可能为空,但不会是空指针错误.
public class 环形链表141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}