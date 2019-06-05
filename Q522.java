package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长特殊序列II
 *
 * @author yx
 * @create 2019-06-05  20:51
 **/
public class Q522 {
    public int findLUSlength(String[] strs) {
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a,String b){
                return a.length()<b.length() ? 1 : (a.length()==b.length() ? 0 : -1);
            }
        };
        Arrays.sort(strs,comp);
        String pre = strs[0];
        int count=1;
        for(int i=1 ; i<strs.length ; i++){
            if(strs[i].length() == pre.length()){
                if(!strs[i].equals(pre)){
                    return pre.length();
                } else{
                    ++count;
                }
            } else{
                if(count==1){
                    return pre.length();
                } else{
                    if(!isSub(pre,strs[i])){
                        count=1;
                        pre = strs[i];
                    }else{
                        count=0;
                    }
                }
            }
        }
        return count==1 ? pre.length() : -1;
    }

    private boolean isSub(String str,String s){
        int index = 0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            index = str.indexOf(c,index);
            if(index==-1){
                return false;
            }
            //str = str.substring(index+1);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"aabbcc", "aabbcc","cb","abc"};
        Q522 q = new Q522();
        System.out.println(q.findLUSlength(strs));
    }
}
