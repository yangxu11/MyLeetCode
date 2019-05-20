package leetcode;
//排列硬币
public class Q441 {
    //二分法
    public int arrangeCoins(int n) {
        if(n==0) return 0;
        long start = 1;
        long end = n;

        while(start<end){
            long mid = start + (end-start)/2;
            if(start == end-1){
                long sum = (1+end)*end/2;
                if( sum<= n){
                    return (int)end;
                } else{
                    return (int)start;
                }
            }

            long num = (1+mid)*mid/2;
            if(num>n){
                end = mid-1;
            } else{
                start = mid;
            }
        }
        return (int)start;
    }
    //71%  公式 x(x+1)/2 = n
    public int arrangeCoins2(int n) {
        return (int) (Math.sqrt((long) n * 2 + 0.25) - 0.5);
    }
}
