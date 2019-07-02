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
    //思路还是求深度递归函数,只不过要求最小.后面的是Math.min + 1;唯一要注意的是,一个树节点有一端为空,则这个树节点的深度不考虑空的一层,因为该树节点不是叶子节点,要从另一侧算,
        //而空的这一层深度为0;最后表示为left+right+1,因为一端为空的情况,必有left或right 为0;当然如果都为null,也不冲突,则为1(当前一个树节点的深度).
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
