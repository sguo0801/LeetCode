package Top100;
//读者可能疑惑，push 操作中含有 while 循环，时间复杂度不是 O(1) 呀，那么本算法的时间复杂度应该不是线性时间吧？
//单独看 push 操作的复杂度确实不是 O(1),但是算法整体的复杂度依然是 O(N) 线性时间。
// 要这样想，nums 中的每个元素最多被 push_back 和 pop_back 一次，没有任何多余操作，所以整体的复杂度还是 O(N)。
//空间复杂度就很简单了，就是窗口的大小 O(k)。

import java.util.LinkedList;

public class _239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //思路是建立一个装索引的双端队列,使得队列中的索引所对应的数是从左(头)到右(尾)单调递减的.
            //保证队列头的索引值对应的数为窗口所有索引中最大的数,头索引若<i-k+1;则去掉头,新的头由于单调递减肯定是剩余最大.
            //末端添加新的数,看值若<末端的值,则不剔除队列中的索引直接填入,若大于,则剔除所有比其小的队列中的索引.相当于后面的胖子把前面压倒啦
            if (nums.length == 0) {
                return new int[]{};
            }
            int[] res = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();  //没有容量,但是根据索引限制
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                    queue.poll();  //限定头索引的出列.因为窗口右移,左边的必然淘汰.
                }
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {  //##要用非常规方法,就在前面不要省对象LinkedList<> = new啦
                    queue.pollLast();
                }
                queue.offer(i);  //添加索引!
                if (i >= k - 1) {  //##>=说明窗口已经能限定三个数啦,可能队列中索引不是三个,这无所谓,只要头(最大值对应的索引)
                    res[index++] = nums[queue.peek()];
                }

            }
            return res;

        }

    }

}
