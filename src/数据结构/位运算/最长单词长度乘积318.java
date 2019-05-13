package 数据结构.位运算;

public class 最长单词长度乘积318 {
    class Solution {
        public int maxProduct(String[] words) {
            //通过一个int数(可以有32位,26个字母足够啦)的二进制数来记录每个单词的各个字母是否出现过,所以字符串数组对应一个int数组
            int n = words.length;
            int[] vals = new int[n];
            for(int i = 0; i < n; i++){ //每个单词
                for(char c : words[i].toCharArray()){  //每个单词中的每个字符
                    vals[i] |= 1 << (c - 'a');  //##用左移来标记出现的字符(字母)对应的1.用或来记录在vals[i]中
                }
            }
            //现在vals[i]中的数对应的二进制就是words对应单词的字母位置.
            int res = 0;  //题中默认不存在是0
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    if((vals[i] & vals[j]) == 0){  //取交为0说明没有重合的字母
                        res = Math.max(res, words[i].length() * words[j].length());  //返回的长度是字符串的长度,知识通过vals来找到满足要求的单词索引
                    }
                }
            }
            return res;
        }
    }
}
