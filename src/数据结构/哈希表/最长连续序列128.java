package 数据结构.哈希表;

import java.util.HashMap;

public class 最长连续序列128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            //用一个HashMap表示每个数字所对应的其连续序列的长度,这是个变化量,比如开始只有1,那么left和right都是0,则1对应的value为1
            //如果这时有2,则2的left为1,right为0,此时2的value为2,注意这里因为互相有影响,要把2-left=1,所对应的value也改成2,依次下去.
            //如果出现先是12,45的情况每个value都是2,当3出现时,1.3.5的value都是5. 主要是边界的1.5要注意,这样子新的数字比如6出现时就不会错,
            //目的还是找最大长度,所以2.4可以不管,只有出现新的值才会更新,旧的不影响最长的长度,所以忽略,也就是可以去重.最长不是1223而是123
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int num : nums) {
                if (!map.containsKey(num)) {  //只有不包括该数字才会可能发生边界变化
                    int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                    int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                    // int left = map.getOrDefault(num-1, 0);
                    // int right = map.getOrDefault(num+1, 0);  //与上面相同,注意如果存在只写key就可以啦,不用写map.get().
                    int newLength = left + right + 1;
                    map.put(num, newLength);  //新的数字已经确定好最长连续序列的长度,即num的value
                    max = Math.max(max, newLength); //每出现一个新的数字看一下是否出现更长的序列长度

                    map.put(num - left, newLength);
                    map.put(num + right, newLength); //把端点的value更新好,这个是重点!相当于两端点之间已经不会变化la,因为只有不包含的数才会更新.
                } else {
                    continue;
                }

            }
            return max;
        }
    }
}
