package leetcode;

/**
 * 根据二叉树创建字符串
 *
 * @author yx
 * @create 2019-06-17  17:34
 **/
public class Q606 {
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        dfs(t);
        String ans = res.toString();
        return ans.substring(1,ans.length()-1);
    }
    public void dfs(TreeNode root){
        if(root ==null) return;
        res.append("("+ root.val);
        if(root.left==null && root.right!=null){
            res.append("()");
            dfs(root.right);
        } else{
            dfs(root.left);
            dfs(root.right);
        }
        res.append(")");
    }
}
