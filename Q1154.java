package leetcode;

/**
 * 一年中的第几天
 *
 * @author yx
 * @create 2019-08-11  10:41
 **/
public class Q1154 {
    int[] run = {0,31,60,91,121,152,182,213,244,274,305,335};
    int[] norun = {0,31,59,90,120,151,181,212,243,274,304,334};

    public static void main(String[] args) {
        Q1154 q = new Q1154();
        System.out.println(q.ordinalOfDate("1900-03-25"));
    }
    public int ordinalOfDate(String date) {
        String[] time = date.split("-");
        int year = Integer.parseInt(time[0]);
        int month = Integer.parseInt(time[1]);
        int day = Integer.parseInt(time[2]);
        int res = 0;

        if(year%4==0){
            res += run[month-1] + day;
        } else{
            res += norun[month-1] + day;
        }

        return res;
    }
}
