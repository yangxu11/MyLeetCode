package leetcode.BinarySearch;

/**
 * 二分查找总结
 *
 * @author yx
 * @create 2019-09-08  10:23
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,3,5,8,15,34,60,76};
        System.out.println(binary1(a,15));
        System.out.println(binary2(a,0));
    }

    //查找确定值
    static int binary1(int[] A,int target){
        int start = 0;
        int end = A.length-1;

        while(start<=end){  //这里可以写start==end，因为需要遍历所有的情况
            int mid = (start+end)/2;

            if(A[mid]>target){
                end = mid-1;
            } else if(A[mid]<target){
                start = mid +1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    //查找数字在数组中的位置
    static int binary2(int[] A,int target){
        int start = 0;
        int end = A.length-1;

        int index = -1;

        while(start<end){
            int mid = (start+end)/2;

            if(A[mid]>target){
                end = mid-1;
            } else if(A[mid]<target){
                start = mid+1;
            } else{
                index = mid;
                break;
            }
        }
        index = index==-1 ? (A[start]>=target ? start : start+1) : index;


        return index;
    }
}
