package leetcode.toutiao;

import java.util.Scanner;

/**
 * 笔试3
 *
 * @author yx
 * @create 2019-06-26  16:42
 **/
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for(int i=0 ; i<n ; i++){
            strs[i] = in.nextLine();
        }
        int[][] nums = new int[n][n];
        for(int i=0 ; i<n ; i++){
            String s = strs[i];
            String[] s1 = s.split(" ");
            for(int j=0 ; j<n ; j++){
                nums[i][j] = Integer.parseInt(s1[j]);
            }
        }
        String line3 = in.nextLine();
        String[] s3 = line3.split(" ");
        int s = Integer.parseInt(s3[0]);
        int d = Integer.parseInt(s3[1]);
        int k = Integer.parseInt(s3[2]);

        System.out.println(f(nums,n,s,d,k));
    }

    private static int f(int[][] nums, int n,int src,int dst,int k) {
        return 0;
    }
}
