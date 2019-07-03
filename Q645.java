package leetcode;

/**
 * 错误的集合
 *
 * @author yx
 * @create 2019-07-03  15:24
 **/
public class Q645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for(int i=0 ; i<nums.length ; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = 0-nums[index];
            } else{
                res[0] = index+1;
            }
        }
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>0){
                res[1] = i +1;
                break;
            }
        }
        return res;
    }
}
