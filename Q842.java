package leetcode;

import java.util.ArrayList;
import java.util.List;
//将数组拆分成斐波那契序列
public class Q842 {
    //执行用时 : 19 ms, 在Split Array into Fibonacci Sequence的Java提交中击败了23.44% 的用户
    //内存消耗 : 36.9 MB, 在Split Array into Fibonacci Sequence的Java提交中击败了0.00% 的用户

    //回溯
    //使用list存储之前满足条件的集合的值，从上次记录的起点st开始，向后遍历字符串
    //如果以‘0’开头，则遍历次数不能大于1（不能出现01这种）
    //如果字符串数值>Integer.MAX_VALUE，则舍弃并且跳出循环
    //如果字符串值<list记载的末尾两项之和，则继续遍历，如果>则跳出循环
    //如果list.size()<2 || 字符串值==list记载的末尾两项之和 则添加到List中递归
    public List<Integer> splitIntoFibonacci1(String S) {
        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();

        bktrace(ans,temp,S,0);

        return ans;
    }

    private void bktrace(List<Integer> ans, List<Integer> temp, String s, int st){

        if(ans.size() != 0){
            return;
        }

        if(st == s.length() && temp.size() >= 3){
            ans.addAll(temp);
            return;
        }

        for(int i = st; i < s.length(); i++){
            if(s.charAt(st) == '0' && i > st){
                break;
            }

            long num = Long.parseLong(s.substring(st,i+1));

            if(num > Integer.MAX_VALUE){
                break;
            }

            int size = temp.size();
            if(size >= 2 && num > temp.get(size-1) + temp.get(size-2)){
                break;
            } else if(size < 2 || num == temp.get(size-1) + temp.get(size-2)){
                temp.add((int)num);
                bktrace(ans,temp,s,i+1);
                temp.remove(temp.size()-1);
            }


        }
    }
    //执行用时 : 92 ms, 在Split Array into Fibonacci Sequence的Java提交中击败了1.56% 的用户
    //内存消耗 : 38.4 MB, 在Split Array into Fibonacci Sequence的Java提交中击败了0.00% 的用户
    public List<Integer> splitIntoFibonacci2(String S) {
        int n = S.length();
        for(int i=1 ; i<=n/2 ; i++){
            for(int j=1 ; Math.max(i,j)+i+j<=n ; j++){
                List<Integer> list = new ArrayList<>();
                if(isValid(i,j,S,list)){
                    return list;
                }
            }
        }
        return new ArrayList<>();
    }
    public boolean isValid(int i,int j,String s,List<Integer> list){
        if(s.charAt(0)=='0' && i>1) return false;
        if(s.charAt(i)=='0' && j>1) return false;

        String sum;
        long x1;
        long x2;
        try{
            x1 = Long.parseLong(s.substring(0,i));
            x2 = Long.parseLong(s.substring(i,i+j));
        } catch(Exception e){
            return false;
        }
        if(x1>Integer.MAX_VALUE || x2>Integer.MAX_VALUE){
            return false;
        }
        list.add((int)x1);
        list.add((int)x2);
        for(int start = i+j ; start!=s.length() ; start+=sum.length()){
            x2 = x1+x2;
            x1 = x2-x1;
            if( x2>Integer.MAX_VALUE){
                return false;
            }
            list.add((int)x2);
            sum = String.valueOf(x2);
            if(!s.startsWith(sum,start)){
                return false;
            }
        }
        return true;
    }
}
