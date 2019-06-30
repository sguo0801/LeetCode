package Top100;

import java.util.ArrayList;
import java.util.List;

//只添加'（'和'）'，我们知道这将保证我们的解决方案（而不是添加太多关闭）。 一旦我们添加一个'（'我们将丢弃它并尝试一个'）'，它只能关闭一个有效的'（'。这些步骤中的每一个都是递归调用的。
public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            helper(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {   //###注意这边是右括号的数量小于左括号
            sb.append(")");
            helper(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
