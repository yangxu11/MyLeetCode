package leetcode.offer;

/**
 * 矩阵中的路径
 *
 * @author yx
 * @create 2019-05-11  17:34
 **/
public class Q65 {
    int xlen,ylen;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        xlen = rows;
        ylen = cols;
        char[][] m = new char[rows][cols];
        int index = 0;
        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                m[i][j] = matrix[index++];
            }
        }
        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                if(m[i][j]==str[0] && isPath(m,new boolean[rows][cols],str,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPath(char[][] matrix,boolean[][] visited,char[] str,int x,int y,int index){
        if(index == str.length) return true;
        if(x<0 || x>=xlen || y<0 || y>=ylen || visited[x][y]|| matrix[x][y] != str[index]){
            return false;
        }
        visited[x][y] = true;
        return isPath(matrix,visited,str,x+1,y,index+1) || isPath(matrix,visited,str,x-1,y,index+1)
                ||isPath(matrix,visited,str,x,y+1,index+1)||isPath(matrix,visited,str,x,y-1,index+1);

    }
}
