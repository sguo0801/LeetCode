package 数据结构.树.Trie前缀树;

public class 键值映射677 {
    class MapSum {
        //有关于前缀的,就要按题型新建内部类
        private class Node {
            private Node[] belong = new Node[26];   //肯定有的Node数组,里面是连接下一个字母的桥梁
            int value;  //根据题型得到value
        }

        Node root = new Node();  //先建立一个根Node节点

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            insert(key, val, root);

        }

        private void insert(String key, int val, Node root) {
            if (root == null) {
                return;
            }
            if (key.length() == 0) {
                root.value = val;  //把值插入到最后的节点,只有遍历到最后完整的key才会出来,才有val
                return;
            }
            int index = indexFor(key.charAt(0));
            if (root.belong[index] == null) {
                root.belong[index] = new Node();  //字符串中的字母匹配到Node中如果还没有值则进行连接.有值不管,直接瞬移
            }
            insert(key.substring(1), val, root.belong[index]);
        }

        public int sum(String prefix) {
            return sum(prefix, root);

        }

        private int sum(String prefix, Node root) {
            if (root == null) {
                return 0;
            }

            if (prefix.length() != 0) {   //说明前缀还没有遍历完,则继续向下遍历,直到前缀结束,开始进行求和
                int index = indexFor(prefix.charAt(0)); //只有向下遍历才会用到index,且这时候才是当前的字母位置
                return sum(prefix.substring(1), root.belong[index]);   //##如果遍历完前缀,后面就不跑啦.
            }
            int res = root.value;  //先把当前的正好=前缀的键所对应的值加上.
            //从匹配到的最后一个节点开始，查找所有子节点，加上这些子节点的和。并且递归地加上这些子节点往下的节点值。
            for (Node node : root.belong) { //此时的root为第一个遍历完成前缀的,后面他的Node数组中的所有值都要加上
                res += sum(prefix, node);  //prefix已经为null,长度为0,即此时没有substring(1).
            }
            return res;
        }

        private int indexFor(char c) {
            return c - 'a';
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
