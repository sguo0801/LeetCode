package Top100;
//思路,根绝()来计数,如果)多,则从左开始删除第一个).方式是采用两个substring连接.继续递归.必须注意删除后有个return,指的是删除后,当前计数满足>=0,则重新回到刚刚的检查位置.
//)在遍历一次后肯定少了,但是(可能还比较多,此时反转字符串,要用StringBuilder,然后反转后,标准的char[],要反过来,相当于字符串一次反转后从右向左去掉多余的(.
//当二次遍历结束,则说明已经()相等,可以添加,这里是看char[]是不是一次反转时的标准来判断字符串当前的反转状态.
import java.util.ArrayList;
import java.util.List;

public class _301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            remove(s, res, 0, 0, new char[]{'(', ')'});
            return res;
        }

        //count为计数器, start是检查到的位置(这之前计数不为负,为负说明')'多了,就要删去.),delete是开始从头检查)的索引,也是删除的位置.
        private void remove(String s, List<String> res, int start, int delete, char[] cs) {
            for (int count = 0, i = start; i < s.length(); i++) {
                if (s.charAt(i) == cs[0]) {
                    count++;
                }
                if (s.charAt(i) == cs[1]) {
                    count--;
                }
                if (count >= 0) {
                    continue;
                }
                //这时)多了,开始删除,原则是从最左侧开始删.
                for (int j = delete; j <= i; j++) {
                    if (s.charAt(j) == cs[1] && (j == delete || s.charAt(j - 1) != cs[1])) {
                        //右侧是要么j就是寻找的首位,要么就是左边不为)可能是其他字符或者(,总之还是说明j当前为第一个).进行去除.
                        remove(s.substring(0, j) + s.substring(j + 1), res, i, j, cs);  //去掉后递归进行下一次移除.
                    }

                }
                return;   //####必须放在for循环的后面.递归调用. 停在这里。递归调用处理字符串的其余部分。
            }
            //开始看反转字符串是否符合要求,因为当前是)肯定比(少,但是如果(多也不行,必须一致,所以,现在目的是去掉多的(;
            //方法是将此时的s反转,然后char[]也反过来,这样子就能利用remove方法就行剔除.
            //##先做出反转字符串.
            String reversed = new StringBuilder(s).reverse().toString();
            if (cs[0] == '(') {   //也就是说刚完成从左到右
                remove(reversed, res, 0, 0, new char[]{')', '('});  //新的一轮从右向左需要从0,0开始,只不过这一次是遇到),计数++.
            } else {  //说明已经完成啦从右到左,并且字符串已经二次反转回来.
                res.add(reversed);   //这里添加的其实是第二次反转的最初字符串.
            }
        }
    }
}
