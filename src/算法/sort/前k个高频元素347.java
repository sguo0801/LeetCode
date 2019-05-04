package 算法.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 前k个高频元素347 {
        public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();  //1.先把所有数放在map中,统计出现次数
        for(Integer num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        //桶的索引是到n,所以建立为new[n+1].因为有0~n中出现次数的可能,建立装链表桶,直接new ArrayList[].
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];  //2.把所有数(不相同),根据value相同的放在桶数组的一个列表中.每个列表中数出现次数相同,且等于桶数组索引,桶数组每一个位置是列表,但是添加元素时,第一次建好list就不需要管它
        for(Map.Entry<Integer, Integer> set : map.entrySet()){ //map的遍历不熟悉啊 //Map.Entry<>和map.entrySet().
            int times = set.getValue();  //得到一个次数(频率).找对应桶的位置
            if(bucket[times] == null){
                bucket[times] = new ArrayList<>();//桶数组对应位置变为列表
                bucket[times].add(set.getKey());  //反过来放入数字(此时是不重复的,之前map的key
            }else{
                bucket[times].add(set.getKey());  //已经变成列表,直接加元素就可以
            }
        }

        List<Integer> top = new ArrayList<Integer>();
        for(int i = bucket.length - 1; i > 0 && top.size() < k; i--){ //3.从后向前遍历桶(用桶的索引)后面频率高.但是同时要保证top中数量小于k.=的时候已经不能再加啦,前k高要保证有k个元素
            if(bucket[i] == null){
                continue;
            }
            if(bucket[i].size() <= k - top.size()){//分情况,一种下一个频率中数目没有超过剩下还需要的数目,就全加入,这里bukcet[i]已经是liet,用size().
                top.addAll(bucket[i]);
            }else{
                top.addAll(bucket[i].subList(0, k - top.size())); //取到正好满足k个数为止.
            }

        }
        return top;
    }
}
