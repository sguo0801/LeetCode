package Top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _15 {
    //我们的想法是对输入数组进行排序，然后运行三元组中可能的第一个元素的所有索引。
    // 对于每个可能的第一个元素，我们对阵列的剩余部分进行标准的双向2Sum扫描。
    // 此外，我们希望跳过相同的元素，以避免在答案中重复，而不会像这样设置或smth。
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 ||  num[i] != num[i-1]) {  //##注意放到一个大括号里面,如果不满足,返回for循环i++;
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];   //先确定i,再确定sum
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;  //去掉重复
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;  //正常换到下一对数
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
