package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.List;
//思路就是回溯.不回头
public class 二叉树所有路径257 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<String>();
            if(root != null){  //必须保证root!=null,否则递归中root.left和root.right会越界
                dps(root, "", res);
            }
            return res;
        }

        private void dps(TreeNode root, String path, List<String> res){
            if(root.left == null && root.right == null){
                res.add(path + root.val);
            }
            if(root.left != null){
                dps(root.left, path + root.val + "->", res);  //说明最起码还有left可以添加,就有->
            }
            if(root.right != null){
                dps(root.right, path + root.val + "->", res);  //说明最起码还有right可以添加,就有->
            }
        }
    }
}
