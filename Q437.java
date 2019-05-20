package leetcode;

/**
 * 路径总和III
 *
 * @author yx
 * @create 2019-05-20  19:41
 **/
public class Q437 {
    int pathnumber;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Sum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return pathnumber;
    }


    public void Sum(TreeNode root, int sum){
        if(root == null) return;
        sum-=root.val;
        if(sum == 0){
            pathnumber++;
        }
        Sum(root.left,sum);
        Sum(root.right,sum);
    }
}
