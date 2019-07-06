package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//找到K个最接近元素
public class Q658 {
    //二分法切记，不可以start=mid+1,end=mid-1容易错开，应该start=mid+1 end=mid


    //55%  整体二分法,判断L和L+K到X的距离来查找，如果LX的距离 大于 (L+1)X距离说明偏左，L = mid+1
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int L=0,R=arr.length-k;//首位指针范围以k为单位
        while(L<R){
            int mid=L+(R-L)/2;
            //若前者大，则x应在mid右侧
            if(Math.abs(arr[mid]-x) > Math.abs(arr[mid+k]-x))
                L=mid+1;
            else
                R=mid;
        }
        for(int i=L;i<L+k;i++)
            list.add(arr[i]);
        return list;
    }

    //30%  先找到最接近x的元素，然后双指针判断前后距离，最后排序
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = -1;

        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>x){
                end  = mid-1;
            } else if(arr[mid] < x){
                start = mid+1;
            } else{
                index = mid;
                break;
            }
        }
        index = index == -1 ? start : index;
        int l = index-1;
        int r = index;
        while(l>=0 || r<arr.length){
            int lenL = l>=0 ? Math.abs(x-arr[l]) : Integer.MAX_VALUE;
            int lenR = r<arr.length ? Math.abs(x-arr[r]) : Integer.MAX_VALUE;
            if(lenL<=lenR){
                res.add(arr[l--]);
            } else{
                res.add(arr[r++]);
            }
            if(--k == 0){
                break;
            }
        }
        Collections.sort(res);
        return res;
    }
}
