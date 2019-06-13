package leetcode.toutiao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 还原扑克牌顺序
 *
 * @author yx
 * @create 2019-06-13  19:57
 **/
public class Poka {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        Poka q = new Poka();
        System.out.println(q.getInit(in));
    }

    public String getInit(String str){

        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0 ; i<nums.length ; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=nums.length-1 ; i>=0 ; i--){
            if(queue.size()==0){
                queue.offer(nums[i]);//添加到队尾
            }else if(i==0){
                queue.offer(nums[i]);//添加到队尾
            } else{
                queue.offer(nums[i]);//添加到队尾
                queue.offer(queue.poll());//将队首元素弹出，添加到队尾
            }
        }
        int[] res = new int[nums.length];
        for(int i=nums.length-1 ; i>=0 ; i--){
            res[i] = queue.poll() ;
        }
        String ans = "";
        for(int i=0; i<nums.length ; i++){
            ans += res[i]+" ";
        }
        return ans.trim();
    }
}
