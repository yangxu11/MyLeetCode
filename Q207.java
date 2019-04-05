package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++)//建立邻接图
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        int[] d = new int[numCourses];//记录当前遍历的状态 0 未遍历  -1 正在遍历  1 遍历完成
        for (int i = 0 ;i < numCourses; i++) {
            if (!dfs(graph, d, i))
                return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int[] d, int index) {
        if (d[index] == 1) return true; //当前节点已经遍历完成，说明该节点没问题，true
        if (d[index] == -1) return false;//如果当前节点正在被遍历，说明出现循环，false
        d[index] = -1;//节点正在遍历
        for (int i = 0; i < graph[index].size(); i++) {
            if (!dfs( graph, d, graph[index].get(i)))
                return false;
        }
        d[index] = 1;//节点遍历完成
        return true;
    }



    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        int count=0;

        Point[] indegree = new Point[numCourses];

        for(int i=0 ; i<prerequisites.length ; i++) {
            if(indegree[prerequisites[i][0]]==null) {
                indegree[prerequisites[i][0]] =new Point(prerequisites[i][0],1);
            } else {
                indegree[prerequisites[i][0]].indegree++;
            }
        }

        LinkedList<Point> queue = new LinkedList<>();

        for(int i=0 ; i<indegree.length ; i++) {
            if(indegree[i]==null) {
                queue.add(new Point(i,0));
            }
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            count++;
            for(int i=0 ; i<prerequisites.length ; i++) {
                if(prerequisites[i][1] == p.vertex) {
                    if(--indegree[prerequisites[i][0]].indegree==0) {
                        queue.offer(indegree[prerequisites[i][0]]);
                    }
                }
            }

        }
        return count==numCourses;
    }
}
class Point{
    int vertex;
    int indegree;

    public Point(int i , int j) {
        this.vertex =i;
        this.indegree = j;
    }

}
