package Top100;
//链表是个,十,百的次序
public class _2 {
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
            int merge = 0;
            ListNode pre = new ListNode(0);   //先设置一个值为0的节点,作为索引节点
            ListNode head = pre;  //最后的返回相关节点
            while (l1 != null || l2 != null || merge != 0) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + merge;
                ListNode cur = new ListNode(sum % 10);   //每一次建立一个新节点.与从高到低445区分,那个是反的所以用栈进行前移.都是要从最低位开始.
                merge = sum / 10;
                pre.next = cur;
                pre = cur;  //进行后移

                l1 = l1 == null ? l1 : l1.next;
                l2 = l2 == null ? l2 : l2.next;
            }
            return head.next;
        }
    }
}
