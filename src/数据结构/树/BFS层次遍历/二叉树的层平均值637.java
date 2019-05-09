package 数据结构.树.BFS层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值637 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
//ArrayList内部是使用可増长数组实现的，所以是用get和set方法是花费常数时间的，但是如果插入元素和删除元素，除非插入和删除的位置都在表末尾，否则代码开销会很大，因为里面需要数组的移动。
//LinkedList是使用双链表实现的，所以get会非常消耗资源，除非位置离头部很近。但是插入和删除元素花费常数时间。
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();  //LinkedList<>()

            if (root == null) {
                return res;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {  //外面大循环是一直层次遍历到二叉树都结束
                int n = queue.size();  //n是当前层的节点数
                double sum = 0.0; //每次都要更新一层的总节点值,所以new
                for (int i = 0; i < n; i++) {
                    TreeNode temp = queue.poll();
                    sum += temp.val;
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }

                }
                res.add(sum / n);
            }
            return res;
        }
    }
}
