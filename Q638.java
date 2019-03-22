package leetcode;

import java.util.ArrayList;
import java.util.List;
//大礼包
public class Q638 {
    //执行用时: 61 ms, 在Shopping Offers的Java提交中击败了34.07% 的用户
    //内存消耗: 28.5 MB, 在Shopping Offers的Java提交中击败了36.84% 的用户

    //深度优先搜索
    //先算出不使用大礼包时，需要花费的总数
    //遍历大礼包，如果大礼包不超出购物车，则比较得出使用大礼包和不使用的较小值，返回这个最小值
    //主要needs数组数量减少之后，要补回来
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Integer res = 0;
        Integer n = price.size();

        for(int i = 0; i < n; i++) {
            res += price.get(i) * needs.get(i);
        }

        for(List<Integer> offer:special) {
            boolean flag = true;
            for(int i = 0; i < n;i++) {
                if(needs.get(i)<offer.get(i)) {
                    flag = false;
                }
                needs.set(i, needs.get(i)-offer.get(i));
            }
            if(flag) {
                res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(n));
            }

            for(int i = 0; i < n;i++) {
                needs.set(i, needs.get(i)+offer.get(i));
            }
        }
        return res;
    }
    //超时答案
    //深度优先搜索，先从大礼包中遍历是否有满足购物车的礼包，如果满足扣去大礼包中的数量，递归
    //然后再从单件商品中遍历,扣去单件商品数量，递归
    public int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price,special,needs,0);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int min){
        if(isEmpty(needs)) return min;

        int mon = Integer.MAX_VALUE;

        for(List<Integer> list : special){
            int flag = 0;
            for(int i=0 ; i<list.size()-1 ; i++){
                if(list.get(i) > needs.get(i)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                List<Integer> temp = new ArrayList<>(needs);
                for(int j=0 ; j<needs.size() ; j++){
                    temp.set(j,needs.get(j)-list.get(j));
                }
                mon = Math.min(mon,dfs(price,special,temp,min+list.get(list.size()-1)));
            }
        }

        for(int i=0 ; i<price.size() ; i++){
            if(needs.get(i)>0){
                List<Integer> temp = new ArrayList<>(needs);
                temp.set(i,needs.get(i)-1);
                mon = Math.min(mon,dfs(price,special,temp,min+price.get(i)));
            }
        }

        return mon;
    }
    public boolean isEmpty(List<Integer> needs){
        for(int i : needs){
            if(i>0) return false;
        }
        return true;
    }
}
