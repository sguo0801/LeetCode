package 算法.Double_Pointer;
//从后往前放.
public class 合并两个有序数组88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[i + j + 1] = nums2[j--];  //注意不同数组的变量名,别马虎.
            } else {
                nums1[i + j + 1] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[i + j + 1] = nums2[j--];
        }
    }
}
