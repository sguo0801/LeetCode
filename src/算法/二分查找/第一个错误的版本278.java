package 算法.二分查找;
//不是+-1变化的,就循环条件为l<r.大多数情况下都是这样,最后返回l与r都可以,因为相同
public class 第一个错误的版本278 {
//    /* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
//
//    public class Solution extends VersionControl {
//        public int firstBadVersion(int n) {
//            int l = 0;
//            int r = n;  //这里是长度值.
//            while(l < r){
//                int mid = l + (r - l) / 2;
//                if(isBadVersion(mid)){
//                    r = mid;  //主要是要第一个版本,这里为true,可能就是这里出的问题.所以mid不能舍.
//                }else{
//                    l = mid + 1;
//                }
//            }
//            return l;
//        }
//    }
}
