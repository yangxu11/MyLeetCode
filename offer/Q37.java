package leetcode.offer;

/**
 * 排序数组中数字出现的次数
 *
 * @author yx
 * @create 2019-05-07  17:59
 **/
public class Q37 {
    //先二分，再迭代
    public int GetNumberOfK(int [] array , int k) {
        int index = -1;
        int start = 0;
        int end = array.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(array[mid]>k){
                end = mid-1;
            } else if(array[mid] < k){
                start = mid+1;
            } else{
                index = mid;
                break;
            }
        }
        if(start==end){
            if(array[start]==k){
                return 1;
            } else{
                return 0;
            }
        }
        int res = 0;
        for(int i=index ; i>=0 ; i--){
            if(array[i] != k){
                break;
            }
            ++res;
        }
        for(int i=index+1 ; i<array.length ; i++){
            if(array[i] !=k){
                break;
            }
            ++res;
        }
        return res;
    }
}
