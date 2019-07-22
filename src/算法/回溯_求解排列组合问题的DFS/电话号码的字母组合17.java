package 算法.回溯_求解排列组合问题的DFS;
//时间复杂度： O(3^N * 4^M)，其中 N 是输入数字中对应 3 个字母的数目（比方说 2，3，4，5，6，8）， M 是输入数字中对应 4 个字母的数目（比方说 7，9），N+M 是输入数字的总数。
//
//空间复杂度：O(3^N * 4^M) ，这是因为需要保存 3^N * 4^M个结果。
import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17 {
    class Solution {

        final String[] pool = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits == null || digits.length() == 0){
                return res;
            }

            dps(new StringBuilder(), res, digits);
            return res;
        }

        private void dps(StringBuilder sb, List<String> res, final String digits){  //注意final加入
            if(sb.length() == digits.length()){
                res.add(sb.toString());  //sb不是String类型,要转换
                return;  //如果字符串已经到了数字按键的长度,则可以添加进res中返回.
            }
            //用sb的长度来选取digits的字符
            int index = digits.charAt(sb.length()) - '0';  //跟0的差距来选择字符串数组中的对应字符
            String letters = pool[index];  //取出数字对应的字符集
            for(char c : letters.toCharArray()){  //遍历字符集中的每个字符,foreach循环不用charAt.
                sb.append(c); //添加
                dps(sb, res, digits);  //向后递归,此时长度发生变化,可以遍历下一个数字对应的字符.
                sb.deleteCharAt(sb.length() - 1);  //删除之前添加的最后一个字符开始回到当前层继续遍历该层后面的letters中字符.sb删除指定字符用deleteCharAt(i);
            }
        }
    }
}
