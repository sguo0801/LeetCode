package Top100;
//给定由开始和结束时间[[s1，e1]，[s2，e2]，...]（si <ei）组成的会议时间间隔数组，找到所需的最小会议室数。
//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.就是[0, 30]一个,后面一个.
//思路:因为Meeting Room太简单所以我直接跳过了。那一题就是找有没有overlap而已，根据start time排序然后看看哪个有没有end time大于之后的start time即可。
//这一题就不太一样了。这一题，本质也是算overlap，只是它算的是存在overlap的区间里最多overlap了几个。
//做法还是涉及到排序。但是要有两个排序，start time一个排序， end time一个排序。或者理解为混着一起排序就可以了。
//假设有一个x轴上面排着这些时间，有一个计数器，从左往右扫，遇到start time的时候就表示要开一个房间了，计数器加一。
// 遇到end time的时候就表示可以关掉一个房间了，计数器减一。不需要考虑哪个end time对应的是哪个start time。
// 所以这一题的结果其实就是在这个扫的过程里，这个计数器的峰值。


import java.util.Arrays;

public class _253会议室2 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int count = 0;
        int res = 0;
        //先给两个时间数组赋值.
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        //##要排序!!
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j = 0; i < start.length;) {
            if (start[i] < end[j]) {
                count++;
                i++;
                res = Math.max(res, count);
            } else {
                count--;
                j++;
            }

        }
        return res;
    }
}
