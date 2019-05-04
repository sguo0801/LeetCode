package 数据结构.链表;

public class 分隔链表725 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] res = new ListNode[k];
            //先求长度
            int len = 0;
            ListNode n = root;
            while (n != null) {  //不能用root改变,否则后面赋值会被影响
                len++;
                n = n.next;
            }
            int m = len / k;//每个部分的节点最少值.
            int r = len % k;//多的节点分给前面开始的r个部分.
            int i = 0;  //for里面只能这是一个初始值.
            ListNode temp = null;  //写在外面,节省内存.
            for (ListNode node = root; node != null && i < k; i++, r--) {  //这里node!=null,是输入链表中还有节点.
                //开始填充数组每个部分.
                res[i] = node;  //填进去的都是链表,表现出来是头结点

                for (int j = 0; j < m + (r > 0 ? 1 : 0); j++) {
                    //填充链表.
                    temp = node;  //记录已经填入该部分的链表节点.
                    node = node.next;
                }
                temp.next = null;  //二级循环完毕,开始进行下一轮循环,截掉链表+null.
                //node.next = null; //上面链表到达长度啦,强行尾部加null.但是不能影响下一部分的node,所以要新建一个节点
            }
            return res;
        }
    }
}
