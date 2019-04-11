package leetcode.homework;
//建立四叉树
public class Q427 {

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
    public Node construct(int[][] grid) {
        if(grid.length==0) return null;
        return con(grid,0,grid.length-1,0,grid.length-1);
    }
    public Node con(int[][] grid,int xstart,int xend,int ystart,int yend) {
        if(xstart == xend) return new Node(grid[xstart][ystart]==1,true,null,null,null,null);

        if(allsame(grid,xstart,xend,ystart,yend)) {
            return new Node(grid[xstart][ystart]==1,true,null,null,null,null);
        } else {
            int midx = (xstart+xend)/2;
            int midy = (ystart+yend)/2;
            return new Node(grid[xstart][ystart]==1,false,
                    con(grid,xstart,midx,ystart,midy),
                    con(grid,xstart,midx,midy+1,yend),
                    con(grid,midx+1,xend,ystart,midy),
                    con(grid,midx+1,xend,midy+1,yend));
        }

    }

    public boolean allsame(int[][] grid,int xstart,int xend,int ystart,int yend) {
        int x = grid[xstart][ystart];
        for(int i=xstart ; i<=xend ; i++) {
            for(int j=ystart ; j<=yend ; j++) {
                if(grid[i][j]!=x) return false;
            }
        }
        return true;
    }
}
