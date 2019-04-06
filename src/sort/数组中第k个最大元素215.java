package sort;

import java.util.PriorityQueue;
//Arrays.sort()是nlogn时间,1空间.源码中用的是双轴快排的方法
//双轴快排:
//1.对于很小的数组（长度小于27），会使用插入排序。
//2.选择两个点P1,P2作为轴心，比如我们可以使用第一个元素和最后一个元素。
//3.P1必须比P2要小，否则将这两个元素交换，现在将整个数组分为四部分：
//（1）第一部分：比P1小的元素。
//（2）第二部分：比P1大但是比P2小的元素。
//（3）第三部分：比P2大的元素。
//（4）第四部分：尚未比较的部分。
//在开始比较前，除了轴点，其余元素几乎都在第四部分，直到比较完之后第四部分没有元素。
//4.从第四部分选出一个元素a[K]，与两个轴心比较，然后放到第一二三部分中的一个。
//5.移动L，K，G指向。
//6.重复 4 5 步，直到第四部分没有元素。
//7.将P1与第一部分的最后一个元素交换。将P2与第三部分的第一个元素交换。
//8.递归的将第一二三部分排序。

//直接用优先级队列的最小堆,时间是nlogk,k的空间
//1的空间与n的时间代码在源头中,没弄明白
public class 数组中第k个最大元素215 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> list = new PriorityQueue<>(k);
            for(Integer a : nums){
                if(list.size() < k){
                    list.offer(a);
                }else{
                    if(a > list.peek()){
                        list.poll();
                        list.offer(a);
                    }
                }
            }
            return list.peek();
        }
}
