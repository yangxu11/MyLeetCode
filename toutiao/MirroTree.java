package leetcode.toutiao;

import java.util.Scanner;

/**
 * 完全二叉树镜像
 *
 * @author yx
 * @create 2019-06-13  19:57
 **/
public class MirroTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        System.out.println(reverse(in));
    }

    public static String reverse(String str){
        String[] strs = str.split(" ");
        int step = 1;

        int start = 0;
        int end = start;
        int len = strs.length;
        while(end<len){
            swap(strs,start,end);
            start += step;
            step*=2;
            end += step;
        }
        String res = "";
        for(String s : strs){
            res += s+" ";
        }
        return res;
    }

    private static void swap(String[] strs, int start, int end) {
        while(start<end){
            String tmp = strs[start];
            strs[start] = strs[end];
            strs[end] = tmp;
            start++;
            end--;
        }
    }
}
