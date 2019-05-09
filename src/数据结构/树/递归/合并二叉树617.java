package 数据结构.树.递归;
//单纯左右相加val就好,新建node结点递归出一个新树.
public class 合并二叉树617 {
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null){
                return null;
            }
            if(t1 == null){
                return t2;
            }
            if(t2 == null){
                return t1;
            }

            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
            return node;
        }
    }
}
