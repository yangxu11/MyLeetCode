package leetcode.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2
 *
 * @author yx
 * @create 2019-08-24  20:05
 **/
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> in = new ArrayList<>();
        String groups = scanner.nextLine();
        int nums = Integer.parseInt(groups);

        List<String[]> list = new ArrayList<>();
        for(int i=0 ; i<nums ; i++){
            String xy = scanner.nextLine();
            String[] xys = xy.split(" ");
            int xl = Integer.parseInt(xys[0]);
            String[] strs = new String[xl];
            for(int j=0 ; j<xl ; j++){
                strs[j] = scanner.nextLine();
            }
            list.add(strs);
        }
        Q2 q = new Q2();
        for(String[] strings : list){
            q.print(strings);
        }
    }

    public void print(String[] strs){
        //String[] strs = {"S#","#."};
        int xlen = strs.length;
        int ylen = strs[0].length();
        char[][] ch = new char[xlen][ylen];
        for(int i=0 ; i<xlen ; i++){
            String str = strs[i];
            for(int j=0 ; j<ylen ; j++){
                ch[i][j] = str.charAt(j);
            }
        }
        Q2 q = new Q2();
        if(q.isMaze(ch)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
    int xlen;
    int ylen;
    public boolean isMaze(char[][] grid){
        int xlen = grid.length;
        int ylen = grid[0].length;
        this.xlen = xlen;
        this.ylen = ylen;
        char[][] chars = new char[xlen*3][ylen*3];
        int x = 0;
        int y=0;
        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(grid[i][j]=='S'){
                    x=i;
                    y= j;
                    break;
                }
            }
        }
        for(int i=0 ; i<3*xlen ; i++){
            for(int j=0 ; j<ylen*3 ; j++){
                chars[i][j] = grid[i%xlen][j%ylen];
            }
        }
        x += xlen;
        y += ylen;
        boolean[][] visited = new boolean[3*xlen][3*ylen];
        return isValid(x,y,chars,visited);
    }

    public boolean isValid(int x,int y,char[][] grid,boolean[][] visited){
        if(x<0 || x>=3*xlen || y<0 || y>=3*ylen){
            return true;
        }
        if(visited[x][y]){
            return false;
        }
        visited[x][y] = true;
        if(grid[x][y]=='#'){
            return false;
        } else{
            return isValid(x-1,y,grid,visited) || isValid(x+1,y,grid,visited)
                    ||isValid(x,y-1,grid,visited)||isValid(x,y+1,grid,visited);
        }
    }
}
