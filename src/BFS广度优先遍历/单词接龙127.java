package Twozhizhen;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mian {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            boolean[] marked = new boolean[wordList.size() + 1];  //标记是否已经用过
            int layyer = 1;  //开始的单词也算长度.
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                layyer++;  //说明还没到想要的单词,数目加一
                int size = queue.size();  //##
                while (size-- > 0) {  //看size是否为空????
                    String cur = queue.poll();  //把队列头拿出来作为比较对象
                    for (int i = 0; i < wordList.size(); i++) {
                        if (marked[i]) {  //标记则代表用过了
                            continue;
                        }
                        String need = wordList.get(i);
                        if (isChange(cur, need)) {
                            if (need.equals(endWord)) {  //字符串比较
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
