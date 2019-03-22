package leetcode;

import java.util.ArrayList;
import java.util.List;
//不同的二叉搜索树
public class Q95 {
    //5ms 53%
    //递归得到[1,n]之间直接任意区间所能生成的二叉搜索树，然后以当前数字为根节点层层叠加生成总的树
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList();
        if (n == 0) {
            return result;
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    //问题答案
    //思路：从小往大生成，新来一数，肯定比现有的节点都大 那么n可以成为现在所有树的父节点，并且他们都是n的左子树
    // 第二步就是沿着现有子树的右侧尝试不断插入。 如果插入以后，n还有子树，那么这些子树都是n的左子树。
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if(n==0) return pre;
        TreeNode first = new TreeNode(1);
        pre.add(first);
        int x=2;
        while(x<=n){
            List<TreeNode> cur = new ArrayList<>();
            for(TreeNode node : pre){
                TreeNode node1 = new TreeNode(x);
                node1.left = node;
                cur.add(node1);
                TreeNode head = node;
                while(node.right!=null){
                    TreeNode node2 = new TreeNode(x);
                    node2.left = node.right;
                    node.right = node2;
                    cur.add(head);
                    node.right = node.right.left;
                    node = node.right;
                }
                node.right = new TreeNode(x);
                cur.add(head);
            }
            pre = cur;
            x++;
        }
        return pre;
    }
}
