package Top100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
//BFS的连接,使用优先队列,进行排序
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){  //要先写.
                return null;
            }

            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){  //比较器里面的类型是必须写的.
                public int compare(ListNode o1, ListNode o2){  //注意public int
                    return o1.val - o2.val;  //代表升序.
                }
            });

            for(ListNode list : lists){
                if(list != null){
                    queue.offer(list);  //把头节点放入队列中
                }
            }

            ListNode head = new ListNode(0);
            ListNode temp = head;
            while(! queue.isEmpty()){
                temp.next = queue.poll();
                temp = temp.next;
                if(temp.next != null){   //下一循环的时候会进行截断
                    queue.offer(temp.next);
                }
            }
            return head.next;
        }
    }
}
