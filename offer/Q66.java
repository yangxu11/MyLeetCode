package leetcode.offer;

/**
 * 机器人的运动范围
 *
 * @author yx
 * @create 2019-05-13  19:48
 **/
public class Q66 {
    int count = 0;
    int x ,y;
    public int movingCount(int threshold, int rows, int cols)
    {
        x = rows;
        y = cols;
        if(threshold == 0) return 1;
        boolean[][] visited = new boolean[rows][cols];
        getCount(visited,0,0,threshold);
        return count;
    }
    private void getCount(boolean[][] visited,int rows,int cols,int t){
        int num = getSum(rows) + getSum(cols);
        if(rows<0||rows>=x || cols<0 || cols>=y || num>t || visited[rows][cols]){
            return;
        }
        visited[rows][cols] = true;
        ++count;
        getCount(visited,rows+1,cols,t);
        getCount(visited,rows-1,cols,t);
        getCount(visited,rows,cols+1,t);
        getCount(visited,rows,cols-1,t);

    }
    private int getSum(int a){
        int sum = 0;
        while(a>0){
            sum += a%10;
            a /= 10;
        }
        return sum;
    }
}
