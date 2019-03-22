package leetcode;

import java.util.ArrayList;
import java.util.List;
//复原IP地址
public class Q93 {
    //执行用时: 3 ms, 在Restore IP Addresses的Java提交中击败了87.91% 的用户
    //内存消耗: 37.3 MB, 在Restore IP Addresses的Java提交中击败了0.81% 的用户

    //递归，遍历字符串，向后取子串，如果<256，则将其添加到IP字符串中，如果遍历完s并且IP中正好有四个子串，则符合条件
    //注意0开头的字符串只能为0，后面不可接别的字符
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,new String(),0);
        return res;
    }
    public void dfs(String s,int index,String IP,int num){
        if(num==4 || index>=s.length()){
            if(index == s.length() && num==4){
                res.add(IP.substring(0,IP.length()-1));
            }
            return;
        }
        if(s.charAt(index)=='0'){//0开头的情况
            dfs(s,index+1,IP+"0.",num+1);
            return;
        }
        for(int i=index ; i<s.length() && i<index+3 ; i++){
            if(Integer.parseInt(s.substring(index,i+1))  < 256){
                dfs(s,i+1,IP+s.substring(index,i+1)+".",num+1);
            } else{
                break;
            }
        }
    }
}
