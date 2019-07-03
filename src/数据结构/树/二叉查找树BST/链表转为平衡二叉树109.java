package 数据结构.树.二叉查找树BST;

public class 链表转为平衡二叉树109 {
    //下面是错误答案,原因是mid记为中间偏右的节点,源头在于fast的初始值设置,这样子做在后面以mid作为头的时候,只能断开其后面的链表节点,但是前面的链表节点无法断开,
    // 也就是题目的要求即不能使用mid作为头,要作为左边的最后一个节点,当链表为奇数时,mid为中间的节点,归属于左边链表部分.
    //上面还是有错误!!关键是要找到中间点的左边那个点否则12345.无法是断开的部分是23,之间,所以必须将2返回才可以.
    // public TreeNode sortedListToBST(ListNode head) {
    //        if(head == null){
    //            return null;
    //        }
    //
    //        if(head.next == null){
    //            return new TreeNode(head.val);
    //        }
    //
    //        ListNode mid = toFeed(head); //mid为中间偏右的节点,也就是mid左边节点有可能多一个.
    //        ListNode right = mid.next; //这里返回的都是链表节点.right为右侧的head.也要先保留mid后面的节点,防止找不到
    //        mid.next = null;  //断开链表表示要转化为树节点
    //        TreeNode root = new TreeNode(mid.val); //得到树根节点.
    //        root.left = sortedListToBST(head);
    //        root.right = sortedListToBST(right);
    //        return root;
    //    }
    //
    //    private ListNode toFeed(ListNode head){
    //        ListNode slow, fast;
    //        slow = fast = head;  //记不起来由于while条件必须把fast设置为head.next的原因啦.
    //        while(fast != null && fast.next != null){ //必须都满足才可以进行跳跃
    //            slow = slow.next;
    //            fast = fast.next.next;
    //        }
    //        return slow; //这个点偶数链表时会偏向右
    //    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //分割链表与148相同.
    //思路,找到链表的root及第一次分段的点(root和之前的节点断开),root根据pre找,将pre跟root断开后,
    // 要建立真正的根rroot,因为首先是要将链节点转换为树节点,另外原root与后面的节点相连,可能不是树要的指向连接,但是,这个原链的连接不能断,否则后面的链(root后面)无法递归
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }

            if(head.next == null){
                return new TreeNode(head.val);  //不能跟上面合起来写,注意空指针异常.
            }

            ListNode premid = toFeed(head);  //此时premid为中间点前一个点,因为fast初始为head.next;
            ListNode root = premid.next;
            //root即为树的根节点,1234,即premid为1,root为2,左1,右2;(这里左2,右1也可以,代码改动只需要把toFeed中fast初值改成head即可)
            //若12345,则premid为2,root为3.左2,右2,均符合要求.
            premid.next = null; //这里其实是把root的前面断掉,这样没有指向root的节点,确立为root.这里是指针
            TreeNode rroot = new TreeNode(root.val);  //根据root确立根节点.这里是值.
            rroot.left = sortedListToBST(head);
            rroot.right = sortedListToBST(root.next);
            return rroot;

        }

        private ListNode toFeed(ListNode head){
            // if(head == null){
            //     return null;  //先排除null,防止fast不能正确初始化.
            // }
            ListNode slow = head;
            ListNode fast = head.next; //##题目的核心就在这里,能够使在fast完成遍历时slow在中间偏左的位置
            ListNode pre = head;  //##pre赋值为head.最后的核心在这里,返回的是premid.保证12345,返回2,root为3,再中间断掉.1234的话就是返回1,root为2,在断掉,左1,右2;
            while(fast != null && fast.next != null){   //###要用&&,都要满足不为空才可以.
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            return pre; //##
        }
    }
}
