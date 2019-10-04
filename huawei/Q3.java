package leetcode.huawei;

/**
 * 3
 *
 * @author yx
 * @create 2019-09-25  19:41
 **/
public class Q3 {
    static int[] nums = {2,1,3};

    public static void main(String[] args) {
        getValue(nums);
    }
    public static void getValue(int[] nums){
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i=1 ; i<nums.length ; i++){

            int target = nums[i];
            int index = i;
            int endIndex = i;
            boolean flag = false;
            for(int j=i-1 ; j>=0 ; j--){
                if(nums[j]<=target && !flag){
                    flag=true;
                    endIndex = j+1;
                }
                if(nums[j]>=target){
                    nums[j+1] = nums[j];
                } else{
                    index = j+1;
                    break;
                }
            }
            int count = index-(i-endIndex);
            res += count;
            max= Math.max(res,max);
        }
        System.out.println(max);
        System.out.println(res);
    }
}
