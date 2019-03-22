package leetcode;

import java.util.HashSet;

//第三大的数
public class Q414 {
    //3ms 92%  使用Long来解决初始三个数的值，如果用int，在数组中出现Integer.MIN_VALUE时不好判断
    public int thirdMax1(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;


        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==first || nums[i]==second || nums[i]==third){
                continue;
            }
            if(nums[i]>first){
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i]>second){
                third = second;
                second = nums[i];
            } else if(nums[i]>third){
                third = nums[i];
            }
        }

        return (int)(third==Long.MIN_VALUE ? first : third);

    }
    //13ms 24%  使用hashset去除重复元素
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int num =0;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++){
            set.add(nums[i]);
        }

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==first || nums[i]==second || nums[i]==third){
                continue;
            }
            if(nums[i]>first){
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i]>second){
                third = second;
                second = nums[i];
            } else if(nums[i]>third){
                third = nums[i];
            }
        }

        return set.size()<3 ? first : third;

    }


}
