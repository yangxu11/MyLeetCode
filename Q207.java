package leetcode;

import java.util.LinkedList;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
