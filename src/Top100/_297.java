package Top100;

import java.util.Arrays;
import java.util.LinkedList;

public class _297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serial(new StringBuilder(), root).toString();
        }
        private StringBuilder serial(StringBuilder sb, TreeNode root){
            if(root == null){
                return sb.append("#");
            }
            sb.append(root.val).append(",");   //添加的是root.val.注意不是字符串
            serial(sb, root.left).append(",");  //直接递归不多BB.
            serial(sb, root.right);  //右节点被上层的,写好啦.
            return sb;   //序列化得到:1,2,null,null,3,4,5.没要求常规遍历,能回去就恶性
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserial(new LinkedList<>(Arrays.asList(data.split(","))));  //##注意别马虎!
        }
        private TreeNode deserial(LinkedList<String> list){  //不需要也没有根节点
            String sb = list.poll();  //##先提出第一部分子串
            if("#".equals(sb)){
                return null;
            }
            //不为空就转换成节点
            TreeNode root = new TreeNode(Integer.valueOf(sb));  //sb为数值
            root.left = deserial(list);
            root.right = deserial(list);
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
