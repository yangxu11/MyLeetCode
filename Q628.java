package leetcode;

import java.util.Arrays;

//三个数的最大乘积
public class Q628 {
    //34ms 55%  排序  注意数组的负数部分
    //结果为 一个最大的正数和两个最小的负数    或者    三个最大的数
    public int maximumProduct(int[] nums) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(nums);
        int result=0;
        int len = nums.length;
        result = Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[0]*nums[1]*nums[len-1]);
        return result;
    }
    //17ms 85% 直接找到三个最大的数  和两个最小的负数
    public int maximumProduct1(int[] nums) {
        int one = -1001;
        int two = -1001;
        int three = -1001;
        int indexOne=0;
        int indexTwo=0;

        int x = -1001;
        int index = 0;
        int y = -1001;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>one){//最大值
                one = nums[i];
                indexOne=i;
            }
            if(nums[i]<0 && Math.abs(nums[i])>x){//最小负数
                x = Math.abs(nums[i]);
                index = i;
            }
        }
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>two && i!=indexOne){//第二大值
                two = nums[i];
                indexTwo=i;
            }
            if(nums[i]<0 && Math.abs(nums[i])>y && i!=index){//第二小的负数
                y = Math.abs(nums[i]);
            }
        }
        for(int i=0 ; i<nums.length ; i++){//第三大值
            if(nums[i]>three && i!=indexOne && i!=indexTwo){
                three = nums[i];
            }
        }

        int r1 = Integer.MIN_VALUE;
        if(x!=-1001 && y!=-1001){
            r1 = x*y*one;
        }
        int r2 = one * two *three;

        return Math.max(r1,r2);
    }
}
