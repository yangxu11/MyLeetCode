package leetcode;

import java.util.Arrays;

public class Q475 {
    //74%
    //要先对两个数组排序
    //取房子到前一个取暖器和后一个取暖器距离的最小值，如果这个距离大于radius，扩大radius
    //注意第一个取暖器附近的房子
    //减小算法复杂度，要找到大于房子的取暖器，然后取最小值
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heat=0;
        for(int i=0 ; i<houses.length ; i++){
            while(heat<heaters.length && heaters[heat]<houses[i]){//找到大于房子值的取暖器
                heat++;
            }
            int len=0;
            if(heat==heaters.length){//最后的取暖器
                len = Math.abs(heaters[heat-1]-houses[i]);
            } else if(heat==0){//第一个取暖器
                len = Math.abs(houses[0]-heaters[0]);
            } else if(heat!=0){//取较小值
                len = Math.min(Math.abs(heaters[heat]-houses[i]),Math.abs(heaters[heat-1]-houses[i]));
            }
            if(len>radius){
                radius = len;
            }
        }
        return radius;
    }
}
