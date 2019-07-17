package Top100;
//分割链表与109一样.但是那边pre初始要为head,否则会有空指针异常,fast初始值不同只影响分割偶数个节点的链表,本题均分为2.2,则fast初始值为head
//平衡二叉树那道题目,因为还要再pre后面加root,所以,1.3分割,这样root左1右2.但是如果与本题分割一致,变成root左2右1,一样通过,只是结果不同.
//题目要求时间空间复杂度分别为O(nlogn)和O(1)，根据时间复杂度我们自然想到二分法，从而联想到归并排序；
//对数组做归并排序的空间复杂度为O(n)，而根据链表可以通过修改引用来断开的特性，无需开辟额外空间，因此可以满足题目O(1)空间复杂度的要求；
public class _148 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
//思路: 先分割链表,然后进行各自排序(有点归并的意思,都是分割到一个节点的链然后合并时排序);最后合并到最初的两条链再合二为一.
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            //分割
            ListNode pre = head;
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;


            //排序
            ListNode l1 = sortList(head);  //左半边排序,其实就是继续分割
            ListNode l2 = sortList(slow);  //右半边排序,现在slow为右半边的头.

            //合并
            return merge(l1, l2);
        }

        //合并就是三指针移动
        private ListNode merge(ListNode l1, ListNode l2){
            ListNode l = new ListNode(0);  //不动,最后返回的头就跟它有关
            ListNode p = l;  //相当于索引指针节点
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }else{
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;  //三指针的后移过程.索引指针是每次都会移动
            }
            if(l1 != null){
                p.next = l1;  //l1还有剩
            }
            if(l2 != null){
                p.next = l2;
            }
            return l.next;
        }
    }
}
