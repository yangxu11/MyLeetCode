package leetcode.offer;

/**
 * 旋转数组中的最小数字
 *
 * @author yx
 * @create 2019-05-03  11:33
 **/
public class Q6 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int start = 0;
        int end = array.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(array[start]>array[end]){
                if(array[mid]>=array[start]){
                    if(array[mid+1] <array[mid]){
                        return array[mid+1];
                    }
                    start = mid+1;
                } else if(array[mid]<=array[end]){
                    if(array[mid-1]>array[mid]){
                        return array[mid];
                    }
                    end = mid-1;
                }
            } else if(array[start] <array[end]){
                return array[start];
            } else {
                start++;
            }
        }
        return array[start];
    }
}
