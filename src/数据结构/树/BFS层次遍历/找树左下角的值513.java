package 数据结构.树.BFS层次遍历;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值513 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
//法一,从右向左;法二从左向右,就是先peek()出结果在poll().
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //TreeNode temp = null;  直接更新root即可,不需要新建节点
            while (!queue.isEmpty()) {
                root = queue.poll();
                //开始从右往左添加节点,这样最后一个从队列中弹出的就是最后一行最左边的节点
                if (root.right != null) {
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
            }
            return root.val;
        }
    }
}
