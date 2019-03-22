package leetcode;

import java.util.ArrayList;
import java.util.List;
//括号生成
public class Q22 {
    //执行用时: 4 ms, 在Generate Parentheses的Java提交中击败了66.07% 的用户
    //内存消耗: 40 MB, 在Generate Parentheses的Java提交中击败了0.98% 的用户

    //递归，
    // 当 (<n && (>) 时下一步可能添加(,)
    // 当 (<n && (==) 时只能添加(
    // 当 (==n && (>) 时只能添加)
    //当）==n时，list.add(s)
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        getString(new String(),0,0,n);
        return res;
    }

    public void getString(String s,int l,int r,int n){
        if(r==n){
            res.add(s);
        }
        if(l<n && l>r){
            getString(s+"(",l+1,r,n);
            getString(s+")",l,r+1,n);
        } else if(l<n && l==r){
            getString(s+"(",l+1,r,n);
        } else if(l==n && l>r){
            getString(s+")",l,r+1,n);
        }
    }
}
