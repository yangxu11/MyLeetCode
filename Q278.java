package leetcode;
//第一个错误版本
public class Q278 {
    //注意，取mid时(start+end)/2可能会越int的边界，应使用start+(end-start)/2
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start<end){
            int mid = start+(end-start)/2;//防止int越界
            if(!isBadVersion(mid)){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
