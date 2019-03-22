package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//寻找右区间
public class Q436 {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  //O(n^2) 20%  暴力遍历
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        for(int i=0 ; i<intervals.length ; i++){
            int end = intervals[i].end;
            int index = Integer.MAX_VALUE;
            int start = -1;
            for(int j=0 ; j<intervals.length; j++){
                if(intervals[j].start>=end && intervals[j].start<index){
                    index = intervals[j].start;
                    start = j;
                }
            }
            result[i] = start;
        }
        return result;
    }
   //70%  O(nlogn)  二分法
    //首先建立一个hash表存储原数组数值和下标对应关系
    //对数组的start进行升序排序
    //遍历排序后的数组，取当前的end为target，二分法寻找后面比target大的最小的start
    public int[] findRightInterval2(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Comparator<Interval> comp = new Comparator<Interval>(){//升序比较器
            public int compare(Interval a , Interval b){
                return a.start>b.start ? 1 : (a.start==b.start ? 0 : -1);
            }
        };
        HashMap<Interval,Integer> map = new HashMap<>();//存储数组下标对应关系
        for(int i=0 ; i<intervals.length ; i++){
            map.put(intervals[i],i);
        }
        Arrays.sort(intervals,comp);//排序
        for(int i=0 ; i<intervals.length ; i++){
            int target = intervals[i].end;
            //二分法寻找
            int start = i;
            int end = intervals.length-1;

            if(intervals[end].start<target){//如果最后的start都不满足条件，不用寻找
                result[map.get(intervals[i])] = -1;
                continue;
            }
            while(start<end){
                int mid = start+(end-start)/2;
                if(intervals[mid].start < target){
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
            result[map.get(intervals[i])] = map.get(intervals[start]);

        }
        return result;
    }
}
