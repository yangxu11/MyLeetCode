package leetcode;

import java.util.*;

//寻找重复的子树
public class Q652 {
//超时答案，将所有子树存到list中，然后遍历root循环比较是否重复
//    List<TreeNode> sameList = new ArrayList<>();
//    List<TreeNode>  diffList = new ArrayList<>();
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        if(root==null) return sameList;
//        int flag=0;
//        int flag1=0;
//        for(TreeNode node : diffList){
//            if(isSameTree(node,root)) {
//                for(TreeNode node1:sameList) {
//                    if(isSameTree(node1,root)) {
//                        flag1=1;
//                    }
//                }
//                if(flag1==0) {
//                    sameList.add(root);
//                }
//                flag=1;
//                break;
//            }
//        }
//        if(flag==0) diffList.add(root);
//        findDuplicateSubtrees(root.left);
//        findDuplicateSubtrees(root.right);
//        return sameList;
//    }
//
//    public boolean isSameTree(TreeNode tree1 ,TreeNode tree2) {
//        if (tree1==null&&tree2==null){//若两棵树均为空
//            return true;
//        }
//        else if (tree1==null||tree2==null){//若两棵树有一方为空
//            return false;
//        }
//        if(tree1!=null&&tree2!=null){
//            if(tree1.val!=tree2.val){
//                return false;
//            }
//            else {
//                return
//                  isSameTree(tree1.left,tree2.left)&&isSameTree(tree1.right,tree2.right);
//            }
//        }
//        return false;
//
//    }

    List<TreeNode> sameList = new ArrayList<>();
    static Map<String,Integer> map = new LinkedHashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return sameList;
        treeToString(root);

        return sameList;

    }
    //遍历子树为后续遍历，每个子树的值为中序遍历
    public String treeToString(TreeNode root) {
        if(root==null) return "#";
        String str =   treeToString(root.left) + "," + root.val +"," +treeToString(root.right);
        if(map.getOrDefault(str,0)==1) sameList.add(root);
        map.put(str,map.getOrDefault(str,0)+1);
        return str;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        Q652 q = new Q652();
        q.findDuplicateSubtrees(root);
        System.out.println(map);

    }
}
