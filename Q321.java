package leetcode;

import java.util.Stack;

/**
 * 拼接最大数
 *
 * @author yx
 * @create 2019-11-14  20:42
 **/
public class Q321 {
    public static void main(String[] args) {
        Q321 q = new Q321();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        System.out.println(q.maxNumber(nums1,nums2,5));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        int len1 = nums1.length;
        int len2 = nums2.length;


        for(int i=0 ; i<=k ; i++){
            if(i>len1 || k-i>len2){
                continue;
            }
            int[] n1 = getNums(nums1,i);
            int[] n2 = getNums(nums2,k-i);
            int[] tmp = merge(n1,n2,k);
            if(getMax(tmp,res)){
                res = tmp;
            }
        }

        return res;

    }

    boolean getMax(int[] n1,int[] n2){
        int k = n1.length;
        for(int i=0 ; i<k ; i++){
            if(n1[i]<n2[i]){
                return false;
            }
        }
        return true;
    }

    int[] merge(int[] n1,int[] n2,int k){
        int[] res = new int[k];
        int len1 = n1.length;
        int len2 = n2.length;
        int i=0,j=0,index=0;
        while(i<len1 || j<len2){
            res[index++] = compare(n1,n2,i,j) ? n1[i++] : n2[j++];
        }
        return res;
    }
    boolean compare(int[] n1,int[] n2,int i,int j){
        while(i<n1.length && j<n2.length && n1[i]==n2[j]){
            ++i;
            ++j;
        }
        return j==n2.length || (i<n1.length && n1[i]>n2[j]);
    }

    int[] getNums(int[] nums,int k){
        int[] res = new int[k];
        if(k==0) return res;
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<len ; i++){
            if(stack.isEmpty()){
                stack.push(nums[i]);
            } else{
                while(!stack.isEmpty() && nums[i]>stack.peek() && len-i+stack.size()>k){
                    stack.pop();
                }
                if(stack.size()<k){
                    stack.push(nums[i]);
                }
            }
        }
        for(int i=k-1 ; i>=0 ; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
