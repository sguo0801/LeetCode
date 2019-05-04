package 算法.贪心思想;

import java.util.ArrayList;
import java.util.List;

public class 分割字符使同字符在一起763 {
        public List<Integer> partitionLabels(String S) {
            int[] a = new int[26]; //26个字母
            for(int i = 0; i < S.length(); i++){
                a[indexChar(S.charAt(i))] = i;  //S的每个字符在对应数组位置显示出最后一个出现的在S上的位置
            }

            int start = 0;  //end每次循环都要更新为start,所以在循环里面初始化
            List<Integer> queue = new ArrayList<>();
            while(start < S.length()){ //外循环是到字符串截止,内循环是找到每一个小段字符串
                int end = start;
                for(int i = start; i < S.length() && i <= end; i++){  //i<=end,要有=,可能是前面的重复字母,也可能是新的字母,所以要看
                    if(a[indexChar(S.charAt(i))] > end){
                        end = a[indexChar(S.charAt(i))];  //=右侧就是该字符出现的最后一个位置,正常开始的循环应该是到end,代表前面可以截成一段字符串,与后面没有任何关联
                    }
                }
                queue.add(end - start + 1);
                start = end + 1;  //更新新的start.开始找下一段字符串
            }
            return queue;

        }

        private int indexChar(char c){
            return c - 'a';
        }
}
