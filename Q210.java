package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 课程表II
 *
 * @author yx
 * @create 2019-04-06  10:56
 **/
public class Q210 {

    //使用栈，先入后出，先入的为后续的课程，后入的为先要学习的课程
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0 ; i<numCourses ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] pair : prerequisites){
            graph[pair[1]].add(pair[0]);
        }
        int[] d = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<numCourses ; i++){
            if(!dfs(graph,d,i,stack)){
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for(int i=0 ; i<res.length ; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(List<Integer>[] graph, int[] d, int index, Stack<Integer> stack) {
        if(d[index]==1) return true;
        if(d[index] == -1) return false;

        d[index] = -1;

        for(int i=0 ; i<graph[index].size() ; i++){
            if(!dfs(graph,d,graph[index].get(i),stack)){
                return false;
            }
        }
        d[index] = 1;
        stack.push(index);
        return true;
    }
}
