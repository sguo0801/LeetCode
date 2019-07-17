package Top100;
//
public class _114 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode prev = null;
        public void flatten(TreeNode root) {
            //思路:应用后序遍历,从最后一个节点出发,比前序少了一个判断全局节点为空的过程,因为前序中,只有全局节点不为空才处理连接指向.而后序不需要判断
            if(root == null){
                return;
            }
            flatten(root.right);  //直奔最右下角的最大值.右下角的两个儿子是null,所以是右下角的节点.之后只要让前一个数的指针指向这个数即可(那是prev为这个数);
            flatten(root.left);
            root.right = prev;  //这边初始为null刚刚好.最后一个节点指向null;
            root.left = null; //手动修改左连接为null.链表只有一端指针.
            prev = root;
        }
    }
    //前序答案在这里
    //题目的关键，每遍历一个节点，就让链表的last节点指向它，就可以了。但是通过递归的入参、出参传递这个信息，需要在增加大量的判断逻辑。可以考虑用全局变量存储传递这个信息。是否豁然开朗？
    //
    //如此，就可以用标准的前序遍历了。
    //
    //    // 增加全局last节点
    //    TreeNode last = null;
    //    private void recursion(TreeNode root) {
    //        if (root == null) return;
    //        // 前序：注意更新last节点，包括更新左右子树
    //        if (last != null) {
    //            last.left = null;
    //            last.right = root;
    //        }
    //        last = root;
    //        // 前序：注意备份右子节点，规避下一节点篡改
    //        TreeNode copyRight = root.right;
    //        recursion(root.left);
    //        recursion(copyRight);
    //    }

}
