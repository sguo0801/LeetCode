package 算法.BFS广度优先遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//思路:列一个队列.先比对字典中只差一个字符的单词.添加进队列,然后继续找下一层的添加,中间要标记已经添加过的字符串.每次都是找当前字符串最近的只差一个字符的字符串.
public class 单词接龙127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            boolean[] marked = new boolean[wordList.size() + 1];  //标记是否已经用过
            int layyer = 1;  //开始的单词也算长度.
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                layyer++;  //说明还没到想要的单词,数目加一,是外面大循环如果上一层还没找到,这边+1,进入下一层的size
                int size = queue.size();  //##
                while (size-- > 0) {  //看size是否为空,用while把同一层级的都选出来.==0时退出当前层级,queue中都是下一层级的元素.到下一层,先判断>0,再--.
                    String cur = queue.poll();  //把队列头拿出来作为比较对象
                    for (int i = 0; i < wordList.size(); i++) {
                        if (marked[i]) {  //标记则代表用过了
                            continue;
                        }
                        String need = wordList.get(i);
                        if (isChange(cur, need)) {
                            if (need.equals(endWord)) {  //字符串比较,是即将变成的字符串相符,则返回不是当前poll出的那个字符串.
                                return layyer;
                            }
                            marked[i] = true;  //不相等就继续找.
                            queue.offer(need);
                        }
                    }
                }
            }
            return 0;  //代表不存在endWord在字典中,或者转不过去.
        }


        public boolean isChange(String cur, String need) {
            int diff = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != need.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
        }
    }
}
