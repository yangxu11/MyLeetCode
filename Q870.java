package leetcode;

import java.util.*;

//优势洗牌
//田忌赛马
public class Q870 {
    //91%  先建立一个map存储原B数组数值对应的下标，方便结果数组的值放到正确的位置
    //然后将两个数组排序，从后遍历B，如果B>=A从头取A值，否则从末尾取A值
    public int[] advantageCount(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0 ; i<B.length ; i++){
            if(map.containsKey(B[i])){
                map.get(B[i]).add(i);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(B[i],list);
            }
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int minIndex = 0;
        int end=A.length-1;
        int start=0;
        for(int i=B.length-1 ; i>=0 ; i--){
            if(B[i]>=A[end]){
                result[map.get(B[i]).get(0)] = A[start];
                map.get(B[i]).remove(0);
                start++;
            } else{
                result[map.get(B[i]).get(0)] = A[end];
                map.get(B[i]).remove(0);
                end--;
            }
        }
        return result;
    }

    //超时答案
    public int[] advantageCount1(int[] A, int[] B) {
        int[] result = new int[A.length];
        Arrays.sort(A);
        int minIndex = 0;
        for(int i=0 ; i<B.length ; i++){
            //int match = Integer.MAX_VALUE；
            int flag=0;
            for(int j=0 ; j<A.length ; j++){
                if(A[j]>B[i] && A[j]!=Integer.MAX_VALUE){
                    result[i] = A[j];
                    A[j] = Integer.MAX_VALUE;
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                while(A[minIndex]==Integer.MAX_VALUE){
                    minIndex++;
                }
                result[i] = A[minIndex];
                A[minIndex]=Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
