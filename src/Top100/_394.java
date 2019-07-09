package Top100;

import java.util.Stack;

public class _394 {
    class Solution {
        public String decodeString(String s) {
            Stack<StringBuilder> strStack = new Stack<>();   //##放builder变量
            Stack<Integer> intStack = new Stack<>();
            StringBuilder sb = new StringBuilder();   //相当于"",也是最后返回的结果,后面就看他怎么变
            int k = 0;  //就是重复的倍数.
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {  //##判断是否为数字
                    k = 10 * k + c - '0';   //可能倍数是多位数.要是有连续第二个数字字符,这里要*10.所以也不急着放入int的栈 ###c已经是字符啦,不要再加''啦!!!!!!!!!
                } else if (c == '[') {
                    //现在可以把[前的数放进栈内啦
                    intStack.push(k);
                    k = 0;   //压入之后直接置0;
                    strStack.push(sb);  //马上开始放字符串啦,这边先把""放进去,或者之前的字符,比如2[a[b]]中b前面的[,先要把a放进去,然后再造一个新的cur
                    sb = new StringBuilder();  //这边就是当前[后面的字符的容器.
                } else if (c == ']') {
                    StringBuilder cur = sb;   //先把]前的字符拿出来,因为这部分并没有入栈
                    int times = intStack.pop();  //准备乘上[]中的字符.
                    sb = strStack.pop();  //a先出栈.此时的sb已经是栈内的a啦,因为之前把最里面[]内部的字符串给了cur
                    for (int i = 0; i < times; i++) {  //##times--
                        sb.append(cur);  //当前[]中的sb(现在是cur)虽然没有放入栈.但是2[a[b]]的情况,如果是最后一个].要把a从栈中弹出且加在b前面.所以依然要先出栈.
                        //上面就是a+b的过程
                    }

                } else {
                    sb.append(c);  //这里的sb还是不在栈内的[]内部的字符串
                }
            }
            return sb.toString();
        }

    }
}
