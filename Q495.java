package leetcode;
//提莫攻击
public class Q495 {
    //9ms 30%  思路都一样
    //判断持续时间和攻击间隔的大小，取小的值
    //注意最后要加上持续时间
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0) return 0;
        int total=0;
        for(int i=1 ; i<timeSeries.length ; i++){
            total += Math.min(timeSeries[i]-timeSeries[i-1],duration);
        }
        return total+duration;
    }
}
