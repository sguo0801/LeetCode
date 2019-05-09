package 数据结构.树.BFS层次遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 非递归中序遍历94 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//中序遍历,左根右
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            while(root != null || ! stack.isEmpty()){
                while(root != null){  //开始把左都放栈中,直到尽头.
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();//是最左下角的节点,这里作为根添加到res中,因为它的左节点为null
                res.add(root.val);
                root = root.right;  //看根的右节点开始是否有子树.
            }
            return res;
        }
    }
}
