package Top100;

import java.util.LinkedHashMap;
import java.util.Map;
//####得重看集合类源码
public class _146 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);  //得有,设置好,重看源码!!!
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);  //继承地方必须加上Integer类型

        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        //@Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > capacity;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
