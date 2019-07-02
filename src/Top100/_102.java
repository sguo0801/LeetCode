package Top100;
//二叉树按层遍历,就是BFS搜索,建立queue队列即可.
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();   //bfs队列
            List<List<Integer>> res = new LinkedList<>();
            //if(root == null){
            //  return res;   //边界条件加上
            //}  这段可以不加,后面有判断根是否为空,最后返回res
            if(root != null){
                queue.offer(root);
            }
            while(! queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new LinkedList<>();
                for(int i = 0; i < size; i++){
                    if(queue.peek().left != null){   //先不弹,往里面放队列头结点的下一层子节点.
                        queue.offer(queue.peek().left);
                    }
                    if(queue.peek().right != null){
                        queue.offer(queue.peek().right);
                    }
                    list.add(queue.poll().val);
                }
                res.add(list);  //一层结束则+一层值
            }
            return res;
        }
    }
}
