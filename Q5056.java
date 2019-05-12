package leetcode;

import java.util.ArrayList;

/**
 * 不邻接种花
 *
 * @author yx
 * @create 2019-05-12  16:14
 **/

public class Q5056 {
    //图着色问题，回溯
    //重点，图的构造方法
    public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i=0 ; i<N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] path : paths){
            graph[path[0]-1].add(path[1]-1);
            graph[path[1]-1].add(path[0]-1);
        }

        int[] res = new int[N];

        for(int i=0 ; i<N ; i++){
            if(res[i]==0){
                dfs(graph,res,i);
            }
        }
        return res;
    }

    public boolean dfs(ArrayList<Integer>[] graph,int[] res,int index){
        outer:for(int i=1 ; i<=4 ; i++){
            for(int p : graph[index]){
                if(res[p] == i){
                    continue outer;
                }
            }

            res[index] = i;

            for(int p : graph[index]){
                if(res[p] == 0){
                    boolean r = dfs(graph,res,p);
                    if(!r){
                        return false;
                    }
                }
            }
        }
        return res[index]>0;
    }

}
