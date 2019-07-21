package 算法.分治;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//与96一样的思想.这里是分治
public class 不同的二叉搜索树95 {
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {  //0为节点的时候,返回[].而不是[[]].
                return new ArrayList<TreeNode>();
            }
            return generateSubtrees(1, n);
        }

        private List<TreeNode> generateSubtrees(int s, int e) {
            List<TreeNode> res = new LinkedList<TreeNode>();
            if (s > e) {
                res.add(null); // empty tree
                return res;
            }

            for (int i = s; i <= e; ++i) {
                List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
                List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

                for (TreeNode left : leftSubtrees) {
                    for (TreeNode right : rightSubtrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
