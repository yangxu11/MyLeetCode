package leetcode;

import java.util.LinkedList;
//01矩阵  BFS 类似一层一层的问题最好使用BFS，DFS需要考虑节点重复遍历问题（树没有，图有）
public class Q542 {
    public static void main(String[] args) {
        Q542 q = new Q542();
        int[][] a = {{1,0,1,1},{1,1,1,1},{0,0,1,1},{1,0,1,1}};
        q.updateMatrix(a);
    }
    int xlen,ylen;
    public int[][] updateMatrix(int[][] matrix) {
        xlen = matrix.length;
        ylen = matrix[0].length;

        if(xlen==0) return matrix;

        LinkedList<Index> queue = new LinkedList<Index>();
        int[][] known = new int[xlen][ylen];
        for(int i=0 ; i<xlen ; i++) {
            for(int j=0 ; j<ylen ; j++) {
                if(matrix[i][j]==0) {
                    add(matrix,i,j,queue,known);
                }
            }
        }
        int level=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int k=0 ; k<size ; k++) {
                Index p = queue.pop();
                matrix[p.x][p.y]=level;
                add(matrix,p.x,p.y,queue,known);
            }
        }
        return matrix;

    }
    public void add(int[][] matrix, int i, int j, LinkedList<Index> queue, int[][] known) {
        if(i-1>=0 && matrix[i-1][j]==1 &&known[i-1][j]==0) {
            queue.offer(new Index(i-1,j));
            known[i-1][j]=1;
        }
        if(i+1<xlen && matrix[i+1][j]==1&&known[i+1][j]==0) {
            queue.offer(new Index(i+1,j));
            known[i+1][j]=1;
        }
        if(j-1>=0 && matrix[i][j-1]==1&&known[i][j-1]==0) {
            queue.offer(new Index(i,j-1));
            known[i][j-1]=1;
        }
        if(j+1<ylen && matrix[i][j+1]==1&&known[i][j+1]==0) {
            queue.offer(new Index(i,j+1));
            known[i][j+1]=1;
        }
    }

    class Index{
        int x;
        int y;
        public Index(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }
}
