package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//无重叠区间   对end进行排序，尽可能容纳更多的区间
//不能对区间长度排序  如[3,5]    [1,4] [4,10]
//贪心算法
public class Q435 {
    class Interval {
        int start;
        int end;
        public Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    class Comparator2 implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.end>b.end ? 1 : (a.end==b.end ? 0 : -1);
        }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length==0) return 0;
        List<Interval> list = new ArrayList<Interval>();
        int remove=0,pre = 0;
        Arrays.sort(intervals,new Comparator2());
        int lastend = intervals[0].end;
        for(int i=1 ; i<intervals.length ; i++) {
            if(intervals[i].start < lastend)
                remove++;
            else
                lastend = intervals[i].end;

        }
        return remove;
    }


}





