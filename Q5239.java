package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 循环码排序
 *
 * @author yx
 * @create 2019-10-27  11:15
 **/
public class Q5239 {
    public static void main(String[] args) {
        Q5239 q = new Q5239();
        System.out.println(q.circularPermutation(16,0));
    }
    public List<Integer> circularPermutation(int n, int start) {
        LinkedList<Integer> gray = new LinkedList<Integer>();
        gray.add(0); //初始化 n = 0 的解
        for (int i = 0; i < n; i++) {
            int add = 1 << i; //要加的数
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        while(gray.peek()!=start){
            gray.offer(gray.poll());
        }
        return gray;
    }
}
