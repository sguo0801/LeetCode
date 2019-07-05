package 数据结构.树.二叉查找树BST;

public class 二叉搜索树的最近公共祖先235 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//最近祖先就是两者间的一个根,即在p,q闭区间中,可以是他们本身.二叉搜索树可以根据值的规律来逐渐限定.
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while(root != null){
                if(root.val > p.val && root.val > q.val){
                    root = root.left;  //两个都在左
                }else if(root.val < p.val && root.val < q.val){
                    root = root.right;  //两个在右右
                }else{
                    return root;
                }
            }
            return null;  //如果没有限定到,就是null,没有共同祖先
        }
    }
    //也可以是递归方法
//    //最近祖先就是两者间的一个根,即在p,q闭区间中,可以是他们本身.
//    class Solution {
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
//            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
//            return root;
//        }
//    }
}
