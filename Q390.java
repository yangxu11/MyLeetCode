package leetcode;

import java.util.LinkedList;

/**
 * 消除游戏
 *
 * @author yx
 * @create 2019-05-01  11:29
 **/
public class Q390 {
//当 n = 1 时，存在 f(n) = 1, b(n) = 1
//对于任意 n，存在 f(n) + b(n) = n + 1
//对于 n > 2 的情况下，f(n) = 2 * b(n / 2)
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }


    //超时
    public int lastRemaining1(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1 ; i<=n ; i++){
            list.add(i);
        }
        while(list.size()>1){
            for(int i=0 ; i<list.size() ; i++){
                list.remove(i);
            }
            if(list.size()==1)
                break;
            for(int i=list.size()-1 ; i>=0 ; i-=2 ){
                list.remove(i);
            }
        }
        return list.get(0);
    }
}
