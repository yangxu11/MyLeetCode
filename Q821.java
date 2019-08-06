package leetcode;

/**
 * 字符的最短距离
 *
 * @author yx
 * @create 2019-08-06  9:24
 **/
public class Q821 {
    public int[] shortestToChar(String S, char C) {
        int index1 = S.indexOf(C);

        int[] res = new int[S.length()];
        for(int i=0 ; i<=index1 ; i++){
            res[i] = index1-i;
        }

        int index2 = S.indexOf(C,index1+1);
        while(index2!=-1){
            for(int i=index1 ; i<=index2 ; i++){
                res[i] = Math.min(i-index1,index2-i);
            }
            index1 = index2;
            index2 = S.indexOf(C,index1+1);
        }
        for(int i=index1+1 ; i<S.length() ; i++){
            res[i] = i-index1;
        }

        return res;
    }
}
