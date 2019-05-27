package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 距离相等的条形码
 *
 * @author yx
 * @create 2019-05-26  11:36
 **/
public class Q1054 {
    public static void main(String[] args) {
        int[] a = {1,1,1,1,2,2,3,3};
        Q1054 q = new Q1054();
        System.out.println(q.rearrangeBarcodes(a));
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]<b[0] ? 1 : (a[0]==b[0] ? 0 : -1);
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        int pre = barcodes[0];
        int count=0;
        for(int i=0 ; i<barcodes.length ; i++){
            if(barcodes[i] == pre){
                count++;
            } else{
                pq.add(new int[]{count,pre});
                pre = barcodes[i];
                count =1;
            }
        }
        pq.add(new int[]{count,pre});
        int[] a0 = pq.peek();
        int step = a0[0];
        int[] tmp = new int[barcodes.length];
        int index = 0;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            for(int i=0 ; i<a[0] ; i++){
                tmp[index++] = a[1];
            }
        }
        LinkedList<Integer> list = new LinkedList<>();

        int x = 1;int cur = 1;
        for(int i=0 ; i<barcodes.length ; i++){
            if(cur>step){
                cur = 1;
                x++;
            }
            list.add(x*cur-1,tmp[i]);
            ++cur;
        }

        int[] res = new int[barcodes.length];
        for(int i=0 ; i<barcodes.length ; i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
