package leetcode;

/**
 * 有效的正方形
 *
 * @author yx
 * @create 2019-06-16  14:49
 **/
public class Q593 {
    //四个点，6个边长，不是边，就是对角线，计算6个线段
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int side1 = 0;
        int side2 = 0;
        int count1=1;
        int count2=1;
        int[][] ps = {p1,p2,p3,p4};

        for(int i=0 ; i<4 ; i++){
            int[] p = ps[i];
            for(int j=i+1 ; j<4 ; j++){
                int[] q = ps[j];
                int len = (p[0]-q[0])*(p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1]);
                if(len==0) return false;
                if(side1==0){
                    side1 = len;
                } else{
                    if(side1==len){
                        ++count1;
                    } else{
                        if(side2==0){
                            side2 = len;
                        } else{
                            if(side2==len){
                                count2++;
                            } else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if((count1==4 && count2==2)||(count1==2 && count2==4)){
            return true;
        }
        return false;
    }
}
