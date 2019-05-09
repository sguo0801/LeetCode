package 数据结构.树.前中后序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 非递归前序遍历144 {
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
        //前序遍历,根左右.
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<Integer>();
            Stack<TreeNode> rights = new Stack<>();

            while(root != null){
                res.add(root.val);
                if(root.right != null){
                    rights.push(root.right);  //只把右节点放在栈中

                }
                root = root.left;  //开始找下一个点,分析是左是右
                if(root == null && ! rights.isEmpty()){  //说明没有左节点但是有右节点,如果没有左也没有右那就直接结束啦,因为后面root为null.
                    root = rights.pop();
                }
            }
            return res;
        }
    }
}
