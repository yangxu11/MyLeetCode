package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的直径
 *
 * @author yx
 * @create 2019-11-04  19:44
 **/
public class Q1245 {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2}};
        Q1245 q = new Q1245();
        System.out.println(q.treeDiameter(edges));
    }
    int res = 0;
    public int treeDiameter(int[][] edges) {
        // Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] map = new ArrayList[edges.length+1];

        for(int i=0 ; i<map.length ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        dfs(map,0,new boolean[edges.length+1]);
        return res;
    }

    public int dfs(List<Integer>[] map, int index, boolean[] visited){

        List<Integer> list = map[index];
        int max1 = 0;
        int max2 = 0;
        for(int next : list){
            if(!visited[next]){
                visited[next] = true;
                int num = dfs(map,next,visited);
                if(num>max1){
                    max2 = max1;
                    max1 = num;
                } else if(num>max2){
                    max2 = num;
                }
            }
        }
        res = Math.max(res,max1+max2);

        return Math.max(max1,max2)+1;

    }
}
