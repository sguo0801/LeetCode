package 数据结构.栈和队列;

import java.util.Stack;

public class 有效的括号20 {
    class Solution {
        public boolean isValid(String s) {
            //用一个栈来装左括号,然后进行匹配.
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }else{  //这边说明肯定是右括号,如果为null,则结束啦,不会进到这里
                    if(stack.isEmpty()){  //栈是empty方法,而集合的isEmpty()通用.栈空则有多余的右括号,则不匹配.
                        return false;
                    }
                    boolean b1 = c == ')' && stack.pop() != '(';  //三种情况,每一个字符c出现如果匹配会有一个为true代表对应不成功
                    boolean b2 = c == '}' && stack.pop() != '{';
                    boolean b3 = c == ']' && stack.pop() != '[';  //栈有pop但不会返回null,如果空了会直接报错哦,队列Queue有poll但栈没有,所以这里只能加上栈为null的情况,说明,没有左括号对应,直接返回false.
                    if(b1 || b2 || b3){//只有false才可以继续匹配,否则就直接失败;上面三种情况,发生一种为true,这里就if成功返回false;
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
