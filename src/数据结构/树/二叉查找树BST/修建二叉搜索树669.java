package 数据结构.树.二叉查找树BST;

public class 修建二叉搜索树669 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return null;
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            //根节点已经满足,开始看左右儿子节点
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
