package leetcode;

/**
 * 求众数
 *
 * @author yx
 * @create 2019-04-03  19:54
 **/
public class Q169 {
    //因为众数的数量> n/2，其中count的值不会<0，每当count==0将缓存的值换成下一个值，count++ =1
    public int majorityElement(int[] nums) {
        int count=1;
        int num = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            if(num == nums[i]){
                count++;
            } else{
                count--;
                if(count==0){
                    num = nums[i+1];
                }
            }
        }
        return num;
    }
}
