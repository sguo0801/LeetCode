package 数据结构.树.Trie前缀树;

public class 实现前缀树208 {
    class Trie {
        //字典树要建立一个内部类,用于确定当前Trie树节点是否对应了字母,并且判断是否为叶子节点
        private class Node {
            private Node[] belong = new Node[26];  //这里是当前节点的对应字母是哪个的数组.且数组中放入下一个节点.代表连接
            private boolean isLeaf;  //默认为false;即不是叶子节点.
        }

        private Node root = new Node();  //##建立一个根节点,符合root的要求,这里不是属性,是必须先生成根的Node().

        /**
         * Initialize your data structure here.
         */
        public Trie() {


        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insert(word, root);

        }

        private void insert(String word, Node root) {
            if (root == null) {
                return;  //说明没有字母挂在上面的不能插入
            }
            if (word.length() == 0) {
                root.isLeaf = true;  //标记,当前这个节点为叶子节点,用于判断是否能搜寻到,搜寻则必须到叶子节点才可以.
                return; //注意完成插入即返回
            }
            int index = indexForbelong(word.charAt(0));  //index为word中对应字母的与'a'的差值,即字母索引,对应每个节点的belong数组
            if (root.belong[index] == null) {
                root.belong[index] = new Node();  //只有为null才添加,说明前面的字符串没有经历过这个单词,否则不为null反而变成一个新Node,则之前同位置的相应后缀都消失啦.
            }

            insert(word.substring(1), root.belong[index]);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, root);

        }

        private boolean search(String word, Node root) {
            if (root == null) {
                return false; //说明没有挂节点,即那个字母不存在
            }
            if (word.length() == 0) {
                return root.isLeaf;
            }
            int index = indexForbelong(word.charAt(0));
            return search(word.substring(1), root.belong[index]);  //根据后面的节点是否挂在前一个的数组索引上判断第一个字母是否匹配
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);

        }

        private boolean startsWith(String prefix, Node root) {
            if (root == null) {
                return false; //说明没有挂节点,即那个字母不存在
            }
            if (prefix.length() == 0) {
                return true;  //与搜索的区别就是不需要判断是否为叶子节点,只要前缀字符串长度为0,即说明满足.
            }
            int index = indexForbelong(prefix.charAt(0));
            return startsWith(prefix.substring(1), root.belong[index]);  //根据后面的节点是否挂在前一个的数组索引上判断第一个字母是否匹配
        }

        private int indexForbelong(char c) {
            return c - 'a';
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
