package 二分查找;
//不是+-1变化的,就循环条件为l<r.大多数情况下都是这样,最后返回l与r都可以,因为相同
public class 第一个错误的版本278 {
//    /* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
//
//    public class Solution extends VersionControl {
//        public int firstBadVersion(int n) {
//            int l = 0;
//            int r = n;
//            while(l < r){
//                int mid = l + (r - l) / 2;
//                if(isBadVersion(mid)){
//                    r = mid;
//                }else{
//                    l = mid + 1;
//                }
//            }
//            return l;
//        }
//    }
}
