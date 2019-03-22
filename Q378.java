package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q378 {
    //堆
    //首先建立一个降序的堆
    //将矩阵元素填入堆中，如果堆未满，无条件添加，堆已满，比较堆顶和当前值，保留较小的一个
    //则最后堆顶元素为第K小的值
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Integer> comp = new Comparator<Integer>(){//降序比较器
            public int compare(Integer a,Integer b){
                return a<b ? 1 : (a==b ? 0 : -1);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);//降序堆

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(pq.size()<k){//堆未满
                    pq.add(matrix[i][j]);
                } else {//堆已满
                    if(pq.peek()>matrix[i][j]){//比较堆顶和当前值
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }

        return pq.poll();
    }
}
