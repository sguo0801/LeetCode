package Top100;
//尤其注意索引值都是s.charAt(i)-'a';
public class _395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            if(s == null || s.length() < k){  //首先解决边界条件.
                return 0;
            }
            //k如果小于2,则相当于没要求
            if(k < 2){
                return s.length();
            }
            return count(s, k, 0, s.length() - 1);

        }
        private int count(String s, int k, int begin, int end){
            if(end - begin + 1 < k){
                return 0;
            }
            int[] times = new int[26];
            for(int i = begin; i <= end; i++){
                times[s.charAt(i) - 'a']++;   //把 每个字符的频率放进数组.
            }
            //开始剔除频率不合适的字符.从左右两侧逼近.
            while(end - begin + 1 >= k && times[s.charAt(begin) - 'a'] < k){  //##不需要到两个指针索引相遇.只要两者之差<k即可跳出循环,并且下面的if返回0.
                begin++;
            }
            while(end - begin + 1 >= k && times[s.charAt(end) - 'a'] < k){  //##注意这里都是字符的int值作为索引.不能直接写end,begin当做索引
                end--;
            }

            if(end - begin + 1 < k){
                return 0;   //这边判断的情况只能是上面两个while都没有遇到符合频率>k的字符结果字符串已经不够k个字符啦.但是上面只要遇到合适的字符就不会<k.
            }

            //开始从两侧第一个符合频率要求的字符串内找不满足频率的字符进行切割
            for(int i = begin; i <= end; i ++){
                if(times[s.charAt(i) - 'a'] < k){  //##这里也是s.charAt(i) - 'a'为索引.
                    return Math.max(count(s, k, begin, i-1), count(s, k, i+1, end));
                }
            }
            return end - begin + 1;  //到这里就是说明从两侧遇到的第一个有效字符起,整条字符串不用切割.
        }
    }
}
