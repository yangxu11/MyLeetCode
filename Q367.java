package leetcode;
//完全平方数
public class Q367 {

    //二分法，注意两数相乘会越int的界，使用long
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int start = 1;
        int end = num/2;
        long target = (long)num;
        while(start<=end){
            int mid = start + (end-start)/2;
            long sq = (long)mid*(long)mid;
            if(sq>target){
                end = mid - 1;
            } else if(sq<target){
                start = mid+1;
            } else{
                return true;
            }
        }
        return false;
    }
}
