package 数据结构.树.递归;

public class 最小路径111 {
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
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            int left = minDepth(root.left);
            int right = minDepth(root.right);
            //如果有单叉树的情况,要按另一边子树计算深度必须到叶子节点才行.12深度为2不是1.所以要判断null的情况
            return root.left == null || root.right == null ? right + left + 1 : Math.min(left, right) + 1;  //后面的+1都是指当前层的root算进深度.
        }
    }
}
