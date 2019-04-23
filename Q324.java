package leetcode;

import java.util.Arrays;

/**
 * 摆动序列II
 *
 * @author yx
 * @create 2019-04-23  20:53
 **/
public class Q324 {
    //排序后 数组分前后两个部分，从各自末尾交叉取值
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] clone = nums.clone();

        int start = nums.length/2-1;
        int end = nums.length-1;

        if(nums.length%2==0) {
            start = nums.length/2 -1;
        } else {
            start = nums.length/2;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(i%2 == 0){
                nums[i] = clone[start--];
            } else{
                nums[i] = clone[end--];
            }
        }

    }
}
