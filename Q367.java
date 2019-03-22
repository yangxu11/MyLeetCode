package leetcode;
//完全平方数
public class Q367 {

    //二分法，注意两数相乘会越int的界，判断边界
    public static boolean isPerfectSquare(int num) {
        if(num<0) return false;
        if(num<=1) return true;
        int start = 1;
        int end = num/2;
        int x = (int)Math.sqrt(Integer.MAX_VALUE);//确定上界
        System.out.println(x*x);

        while(start<=end){
            int mid = start+(end-start)/2;

            if(mid>x || mid*mid > num){//判断边界
                end = mid-1;
            } else if(mid*mid < num){
                start = mid+1;
            } else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
