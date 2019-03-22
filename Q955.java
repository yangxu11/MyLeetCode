package leetcode;

import java.util.ArrayList;
import java.util.List;

//删列造序II
public class Q955 {
    //75%  重点是字典序 和重复字符怎么办
    //先找到符合字典序的第一列，同时整理出重复字符列表
    //根据重复字符表，向下（第一列之后）遍历，如果符合条件，但又重复字符，整理出重复表，循环
    //如果不符合删去这一行，重复字符表不变
    //循环直到重复字符表为空或字符串到头
    public int minDeletionSize(String[] A) {
        int count=0;
        List<Integer> same = new ArrayList<>();
        int index=0;
        for(int j=0 ; j<A[0].length();j++){
            int flag = 0;
            for(int i=1 ; i<A.length ; i++){
                if(A[i].charAt(j)<A[i-1].charAt(j)){
                    count++;
                    same.clear();
                    flag=1;
                    break;
                } else if(A[i].charAt(j)==A[i-1].charAt(j)) {
                    same.add(i);
                }
            }
            if(flag==0){
                index = j;
                break;
            }
        }
        for(int j=index+1 ; j<A[0].length() ; j++){
            List<Integer> list = new ArrayList<>();//新的重复字符表
            int flag=0;
            for(int i : same){
                if(A[i].charAt(j)<A[i-1].charAt(j)){
                    count++;
                    list.add(i);
                    flag=1;
                    break;
                } else if(A[i].charAt(j)==A[i-1].charAt(j)){
                    list.add(i);
                }
            }
            if(list.isEmpty()) break;
            if(flag==0){//符合条件，更新重复字符表，否则same不变
                same = list;
            }
        }
        return count;
    }
}
