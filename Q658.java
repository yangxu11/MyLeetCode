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
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = arr.length-1;
        int index=0;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(start==start){
                index = start;
                break;
            }

            if(arr[mid]>x){
                end = mid;
            } else if(arr[mid]<x){
                start = mid+1;
            } else {
                index = mid;
                break;
            }
        }
        int left = index-1;
        int right = index;

        if(arr[index]>x && index>0){
            if(arr[index]-x > x-arr[index-1]){
                left = index-1;
                right = index;
            }
        }
        if(arr[index]<x && index<arr.length-1){
            if(x-arr[index] > arr[index+1] -x){
                left = index;
                right = index+1;
            }
        }
        int num=0;
        while(num<k){
            int ldiff=Integer.MAX_VALUE;
            int rdiff=Integer.MAX_VALUE;
            if(left>=0){
                ldiff = Math.abs(x-arr[left]);
            }
            if(right<=arr.length-1){
                rdiff = Math.abs(x-arr[right]);
            }
            if(ldiff<=rdiff){
                result.add(arr[left]);
                left--;
            } else{
                result.add(arr[right]);
                right++;
            }
            num++;
        }
        Collections.sort(result);
        return result;
    }
}
