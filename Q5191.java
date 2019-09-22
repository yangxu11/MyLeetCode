package leetcode;

/**
 * 1
 *
 * @author yx
 * @create 2019-09-15  11:33
 **/
public class Q5191 {
    public static void main(String[] args) {
        Q5191 q = new Q5191();

    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        int[] nums = new int[arr.length*2];
        int len = nums.length;
        int total = 0;
        int mod = 100000007;
        for(int i=0 ; i<nums.length ; i++){
            nums[i] = arr[i%arr.length];
            total  = (total+nums[i])%mod;
        }

        int max = nums[0];
        int sum = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            if(sum>0){
                sum += nums[i];
            } else{
                sum = nums[i];
            }
            max = Math.max(sum,max);
        }

        int firstMax = arr[0];
        int firstSum = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            firstSum = (firstSum+arr[i])%mod;
            firstMax = Math.max(firstMax,firstSum);
        }

        int lastMax = arr[arr.length-1];
        int lastSum = arr[arr.length-1];
        for(int i=arr.length-2 ; i>=0 ; i--){
            lastSum = (lastSum+arr[i])%mod;
            lastMax = Math.max(lastMax,lastSum);
        }


        if(max<0) return 0;
        if(k<=2) return max;
        long res = total/2;
        if(total>0){
            return Math.max((int)(res*(k-2)%mod+firstMax+lastMax),max);
        } else{
            return max;
        }
    }
}
