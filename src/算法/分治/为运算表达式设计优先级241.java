package 算法.分治;
//思路:从左到右慢慢分割字符串,然后找符号作为界限,将结果加到res.
import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));  //方法是substring.小写
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));  //以当前运算符和左右递归,都是左右分段String的所有可能结果集合
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {  //##注意写法
                            case '+':  //##直接加'+'
                                res.add(l + r);
                                break;  //##注意break,否则res结果会混在一起.
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {  //最后一段数字
            res.add(Integer.valueOf(input));
        }
        return res;

    }
}
