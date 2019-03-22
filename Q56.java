package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//合并区间
public class Q56 {
     class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
      }

      //对区间start升序排序，那么下一个遍历的区间只能影响res中最后一个区间
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res= new ArrayList<>();
        if(intervals.size() == 0) return res;
        Comparator<Interval> comp = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start>i2.start ? 1 : (i1.start==i2.start ? 0 : -1);
            }
        };
        Collections.sort(intervals,comp);

        res.add(intervals.get(0));
        for(int i=1 ; i<intervals.size() ; i++){
            Interval in = res.get(res.size()-1);
            Interval cur = intervals.get(i);
            if(cur.start>in.end){
                res.add(cur);
            } else{
                res.remove(res.size()-1);
                res.add(new Interval(in.start,Math.max(in.end,cur.end)));
            }
        }
        return res;

    }
}
