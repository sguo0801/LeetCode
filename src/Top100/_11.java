package Top100;

public class _11 {
    //AKA问题
    //如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
    // 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
    // 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。

//双指针,从两侧向中间靠拢,并更新容量.
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])//哪个小换哪个
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
