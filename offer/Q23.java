package leetcode.offer;

/**
 * 二叉树的后序遍历序列
 *
 * @author yx
 * @create 2019-05-12  10:19
 **/
public class Q23 {
    //递归
    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len ==0) return false;
        return isPostOrder(sequence,0,len-1);
    }
    public boolean isPostOrder(int[] num,int start,int end){
        if(start >= end) return true;
        int mid = num[end];
        int index = end;
        for(int i=start ; i<end ; i++){
            if(num[i] > mid){
                index = i;
                break;
            }
        }
        for(int i=index ; i<end ; i++){
            if(num[i] < mid){
                return false;
            }
        }
        return isPostOrder(num,start,index-1) && isPostOrder(num,index,end-1);
    }
}
