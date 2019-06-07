package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长特殊序列II
 *
 * @author yx
 * @create 2019-06-05  20:51
 **/
public class Q522 {
    //思路同521
    //对数组进行长度从长到短排序，如果当前最长相同长度没有重复并且不是比其长的字符串的子序列，则其长度为结果
    public int findLUSlength(String[] strs) {
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a,String b){
                return a.length()<b.length() ? 1 : (a.length()==b.length() ? a.compareTo(b) : -1);
            }
        };
        Arrays.sort(strs,comp);
        String pre = strs[0];
        Set<String> set = new HashSet<>();
        set.add(pre);
        int len = pre.length();
        int count=1;
        for(int i=1 ; i<strs.length ; i++){
            if(strs[i].length() == len){
                if(!set.add(strs[i])){
                    count = count==0 ? 0 : count-1;
                } else{
                    ++count;
                }
            } else{
                if(count>=1){
                    return len;
                } else{
                    int flag = 1;
                    for(String s : set){
                        if(isSub(s,strs[i])){
                            count=0;
                            flag=0;
                            break;
                        }
                    }
                    if(flag==1){
                        count=1;
                        len = strs[i].length();
                        set.add(strs[i]);
                    }
                }
            }
        }
        return count>=1 ? len : -1;
    }

    private boolean isSub(String str,String s){
        int index = 0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            index = str.indexOf(c,index);
            if(index==-1){
                return false;
            }
            ++index;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"j","j","viez","ogk","ogk","lfn","ypmhwx","ypmhwx","m","m","ak","ivivzoncju","ivivzoncju","wmybi","wmybi","dyzfjg","dyzfjg","a"};
        Q522 q = new Q522();
        System.out.println(q.findLUSlength(strs));
    }
}
