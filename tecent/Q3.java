package leetcode.tecent;

/**
 * 3
 *
 * @author yx
 * @create 2019-09-01  21:25
 **/
public class Q3 {
    public static void main(String[] args) {

    }

    public boolean f1(int[] A){

        int[] nums = new int[100000];

        int length = A.length;


        for(int i=0 ; i<length ; i++){
            nums[A[i]] += 1;
            if(nums[A[i]] > length/2){
                return false;
            }
        }
        return false;
    }
}
