package leetcode.offer;

/**
 * 连续子数组的最大和
 *
 * @author yx
 * @create 2019-05-06  17:33
 **/
public class Q30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0) return 0;
        int sum = array[0];
        int res = sum;
        for(int i=1 ; i<array.length ; i++){

            if(sum > 0){
                sum += array[i];
            } else{
                sum = array[i];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
