package leetcode;

public class Q11 {
    //双指针经典题
    //两个指针指向首末，哪端小，哪端推进，因为它已经是最小值了，只有它变化才可能出现更大的值
    public int maxArea(int[] height) {
        int res = 0;
        int start = 0;
        int end = height.length-1;
        while(start < end){
            int len = Math.min(height[start],height[end]);
            res = Math.max(res,(end-start)*len);
            if(height[start]<height[end]){
                start++;
            } else{
                end--;
            }
        }
        return res;
    }
}
