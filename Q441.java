package leetcode;
//排列硬币
public class Q441 {
    //30%  递减
    public int arrangeCoins(int n) {
        for(int i=1 ; ; i++){
            if(n<i){
                return i-1;
            }
            if(n==i){
                return i;
            }
            n -= i;
        }
    }
    //71%  公式 x(x+1)/2 = n
    public int arrangeCoins2(int n) {
        return (int) (Math.sqrt((long) n * 2 + 0.25) - 0.5);
    }
}
