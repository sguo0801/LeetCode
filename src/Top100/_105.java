package Top100;
//已知前序和中序建立树.
import java.util.HashMap;

public class _105 {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //思路:找一个map装填中序数组中的根节点,及索引.方便从前序中找到根对应到中序的索引进行划分.
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);   //键为中序数组中的数,值是中序索引;
            }
            TreeNode res = isHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);  //注意分号要英文的
            return res;
        }

        private TreeNode isHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> map){
            if(prestart > preend || instart > inend){  //索引不能限定值,则返回null
                return null;
            }
            int rootval = preorder[prestart];
            TreeNode root = new TreeNode(rootval);   //要先建立根节点,之后再找其左右,最后返回.
            int inIndex = map.get(rootval);  //因为没有重复的值.
            int numLeft = inIndex - instart; //定好左边子树的数量

            //最开始的prestart还是0.这里都是索引.注意上下两个式子间索引都有关系.
            root.left = isHelper(preorder, prestart+1, prestart+numLeft, inorder, instart, inIndex-1, map);
            root.right = isHelper(preorder, prestart+numLeft+1, preend, inorder, inIndex+1, inend, map);
            return root;
        }
    }
}
