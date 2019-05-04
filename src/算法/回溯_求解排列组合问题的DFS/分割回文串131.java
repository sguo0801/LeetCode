package 算法.回溯_求解排列组合问题的DFS;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串131 {
    class Solution {
        //就是按照s的长度添加进res,判断当前字符串的子串是否为回文串,进行添加list,不回头不需要标记,这里是改变每次剩下的字符串,所以循环都是从0开始.
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            dps(res, new ArrayList<>(), s);
            return res;
        }

        private void dps(List<List<String>> res, ArrayList<String> list, String s){
            if(s.length() == 0){
                res.add(new ArrayList<>(list));
                return;
            }

            for(int i = 0; i < s.length(); i++){  //最开始是一个一个字符作为串填进去,然后i增大,子串开始变大,不满足回文则i继续增大
                if(isFeed(s.substring(0, i+1))){  //当前s以0开始,进行截断为子串判断回文.
                    list.add(s.substring(0, i+1));
                    dps(res, list, s.substring(i+1));
                    list.remove(list.size()-1);
                }
            }
        }

        private boolean isFeed(String s){
            int start = 0;
            int end = s.length()-1;
            while(start < end){
                if(s.charAt(start++) != s.charAt(end--)){
                    return false;
                }
            }
            return true;
        }
    }
}
