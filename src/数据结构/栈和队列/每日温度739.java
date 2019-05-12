package 数据结构.栈和队列;

import java.util.Stack;

public class 每日温度739 {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            //法1,动态规划
            //根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
            //再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
            //对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
            //自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
            //- 若T[i] < T[i+1]，那么res[i]=1；
            //- 若T[i] > T[i+1]
            // - res[i+1]=0，那么res[i]=0;
            // - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
//            int[] res = new int[T.length];
//            res[res.length-1] = 0;  //最后一个肯定为0;
//            for(int i = res.length-2; i >= 0; i--){
//                for(int j = i+1; j < res.length; j += res[j]){
//                    if(T[i] < T[j]){
//                        res[i] = j-i;  //可能是i后面的值的再大值
//                        break;  //填写完了,换下一个i;
//                    }
//                    //else if (T[i] == T[j]){  //等于是题意没有说清楚,如果前后两天温度相同,一样算大于,即也是上升
//                    //  res[i] = j-i+res[j];
//                    //  break;
//                    // }
//                    else{  //大于的话不管就可以啦,自己自动+res[j].但是如果最后j加到最后res[j]为0;则直接置0,避免死循环
//                        if(res[j] == 0){
//                            res[i] = 0;
//                            break;  //记得填写完就break;否则还是死循环
//                        }
//                    }
//
//                }
//            }
//            return res;
            //法2,用栈进行求值,栈中存放索引,从栈中弹出去代表完成res数组填数,否则在最后还在数组中的即为0,不用管默认即可.
            //没有动归好,但是也很灵巧
            int[] res = new int[T.length];
            Stack<Integer> indexStack = new Stack<>();
            for (int i = 0; i < T.length; i++) {  //索引从0开始到最后
                while (!indexStack.empty() && T[indexStack.peek()] < T[i]) {  //小于当前的索引,那么栈顶的索引就可以出来啦
                    int cur = indexStack.pop();
                    res[cur] = i - cur;
                }
                indexStack.push(i); //当前的索引比对完一定要放入栈中
            }
            return res;
        }
    }
}
