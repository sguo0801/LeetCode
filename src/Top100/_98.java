package Top100;

import java.util.Stack;
//跟二叉搜索树相关的题目,94,230.均可用此代码结构.
public class _98 {
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
        public boolean isValidBST(TreeNode root) {
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || ! stack.empty()){ //##注意是||.
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre != null && pre.val >= root.val){  //栈中弹出还是按照中序遍历的顺序,所以只要看前后的节点值作比较就可以.
                    return false;
                }
                pre = root;   //与另两道题目唯一的区别就是把之前的中序排列的上一个节点给pre,与当前的节点进行比较.
                root = root.right;
            }
            return true;
        }
    }
}
