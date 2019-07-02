package leetcode.toutiao;

import java.util.Scanner;

/**
 * 笔试1
 *
 * @author yx
 * @create 2019-06-26  15:51
 **/
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] in1 = line1.split(" ");
        int n = Integer.parseInt(in1[0]);
        int h = Integer.parseInt(in1[1]);
        String[] in2 = line2.split(" ");
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = Integer.parseInt(in2[i]);
        }
        int[] res = f1(nums,n,h);
        for(int i=0 ; i<n ; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] f1(int[] nums,int n , int h){
        int[] res = new int[n];
        if(n==0) return res;
        res[0] = 0;
        for(int i=1 ; i<n ; i++){
            int a = nums[i];
            int diff = h - a;
            double step = 0;
            if(diff < 0){
                diff = Math.abs(diff);
                step = diff*1.0/(i+1);
                for(int j = i-1 ; j>=0 ; j--){
                    int dis = i-j;
                    if(nums[j]+dis*step >= nums[i]){
                        res[i] = j+1;
                        break;
                    }
                }
            } else{
                step = diff*1.0/(i+1);
                for(int j = i-1 ; j>=0 ; j--){
                    int dis = i-j;
                    if(nums[j] >= nums[i] + dis*step){
                        res[i] = j+1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
