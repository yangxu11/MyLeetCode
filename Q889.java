package leetcode;

/**
 * 根据先序遍历和后序遍历构造二叉树
 *
 * @author yx
 * @create 2019-08-17  17:04
 **/
public class Q889 {
    public static void main(String[] args) {
        Q889 q = new Q889();
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        System.out.println(q.constructFromPrePost(pre,post));
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,post,0,pre.length-1,0,post.length-1);
    }
    public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
        if(prestart>preend||poststart>postend)return null;
        TreeNode root=new TreeNode(pre[prestart]);
        if (prestart == preend)
            return root;
        int index=0;
        while(post[index]!=pre[prestart+1]){
            index++;
        }
        root.left=helper(pre,post,prestart+1,prestart+1+index-poststart,poststart,index);
        root.right=helper(pre,post,prestart+2+index-poststart,preend,index+1,preend-1);
        return root;

    }
}
