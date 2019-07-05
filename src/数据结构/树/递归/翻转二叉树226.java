package 数据结构.树.递归;
//保留一边子树的指针,在交换中注入递归.类比swap()
public class 翻转二叉树226 {
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
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }

            final TreeNode left = root.left;
            root.left = invertTree(root.right);  //这个递归方法返回的还是给入的节点,只不过在递归过程中这个给入的节点的子节点都交换好啦.
            // 这里.right相当于链表的.next.所以之前新建个树节点要保留root.left的指针.
            root.right = invertTree(left);  //像是swap()
            return root;  //最后返回的还是root
        }
    }
}
