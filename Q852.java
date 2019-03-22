package leetcode;
//山脉数组的峰顶索引
public class Q852 {
    //3ms 88% 二分法  更加简洁
    //判断mid和mid+1的大小关系，如果mid小，说明最大值一定在后面，如果mid大，说明最大值是<=mid
    public int peakIndexInMountainArray2(int[] A) {
        int start=0;
        int end = A.length-1;

        while(start<end){
            int mid = start+(end-start)/2;
            if(A[mid]<A[mid+1]){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return start;
    }
    //3ms 88%  二分法
    // 中间值小于其中一个边值时，就一定大于另一个边值，所以当A[mid]<A[start] 则 A[mid]>A[end] end = mid
    //当中间值大于两个边值时，start++ end--逼近
    //注意当仅存两个值时要判断做输出
    public int peakIndexInMountainArray(int[] A) {
        int start=0;
        int end = A.length-1;

        while(start<end){
            int mid = start+(end-start)/2;
            if(mid==start || mid==end){//逼近只剩两个值时
                return A[start]>A[end] ? start : end;
            }

            if(A[mid]<A[start]){
                end = mid;
            } else if(A[mid]<A[end]){
                start = mid+1;
            } else {
                start++;
                end--;
            }
        }
        return start;
    }

}
