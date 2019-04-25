package 贪心思想;

public class 判断子序列392 {
    //为什么不通过??
//    class Solution {
//        public boolean isSubsequence(String s, String t) {
//            int i = 0;
//            int j = 0;
//            while(j < t.length()){
//                if(s.charAt(i) == t.charAt(j)){
//                    i++;
//                    if(i >= s.length()){  //==的时候说明已经满足所有s的字符.
//                        return true;
//                    }
//                }
//                j++;
//            }
//            return false;
//        }
//    }

        public boolean isSubsequence(String s, String t) {
            int index = -1;  //以-1为初始值就是从0开始找
            for(char c : s.toCharArray()){
                index = t.indexOf(c, index + 1);  //更新索引,返回在t中的位置,indexOf找从指定值后的第一个索引.
                if(index == -1){
                    return false;
                }
            }  //遍历之后,都找的到
            return true;
        }
}
