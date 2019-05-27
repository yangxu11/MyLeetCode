package leetcode;

import java.util.Arrays;

/**
 * 1
 *
 * @author yx
 * @create 2019-05-26  11:43
 **/
public class Q1051 {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        int res = 0;
        for(int i=0 ; i<copy.length ; i++){
            if(heights[i]!=copy[i]){
                ++res;
            }
        }
        return res;
    }
}
