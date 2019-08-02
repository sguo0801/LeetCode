package 数据结构.数组和矩阵;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 有序矩阵中第k小的元素378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            //法一,优先队列通俗解法,因为是要找小的元素,所以用大顶堆,因为这道题目有排序,所以这样不是很好
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {  //###比较器大括号里放compare
                public int compare(Integer a, Integer b) {  //必须是包装类,必须是compare与compareTo.
                    return b.compareTo(a);  //降序排列.
                }
            });
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (queue.size() < k) {   //不是<=..!!!要注意
                        queue.offer(matrix[i][j]);
                    } else if (matrix[i][j] < queue.peek()) {
                        int a = queue.poll();
                        queue.offer(matrix[i][j]);

                    }

                }
            }
            return queue.peek();
        }
    }
    //法二.二分查找法,不是特别清晰.但是会更快.???????
//    class Solution {
//        public int kthSmallest(int[][] matrix, int k) {
//            //二分查找法
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int low = matrix[0][0];
//            int high = matrix[m-1][n-1];
//            while(low <= high){
//                int mid = low + (high-low)/2;
//                int count = 0;
//                for(int i = 0; i < m; i++){
//                    for(int j = 0; j < n && matrix[i][j] <= mid; j++){
//                        count++;
//                    }
//
//                }
//                if(count < k){
//                    low = mid+1;
//                }else{
//                    high = mid - 1;
//                }
//            }
//            return low;
//        }
//    }
}
