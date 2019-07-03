package Top100;
//找环形链表入环点
public class _142 {
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
//思路是这样,两个节点到第一次相遇时,slow走了(a+b);fast走了,a(当为慢速时起始到入环点的距离)+b+c(相遇点到入环点的距离)+b;
//即a+2b+c=2(a+b);这边当做两倍.则a=c.所以当slow从相遇点再走c,与fast同速从头走a是一样的时间,再次相遇点即为入环点.
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null){
                return null;  //空代表无环.
            }

            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    fast = head;
                    while(fast != slow){
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}
