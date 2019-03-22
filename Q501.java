package leetcode;

import java.util.*;

public class Q501 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static Map<Integer,Integer> map = new HashMap<>();

    public static List<Integer> findMode(TreeNode root) {

        scanTree(root);
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for(int i : map.keySet()) {
            if(map.get(i) > max) {
                result.clear();
                result.add(i);
                max = map.get(i);
            } else if(map.get(i) == max) {
                result.add(i);
            }
        }
        int[] a = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++) {
            a[i] = result.get(i);
        }

        return result;
    }

    public static void scanTree(TreeNode root) {

        if(root == null) return;

        if(map.containsKey(root.val)) {
            map.put(root.val,map.get(root.val)+1);
        } else {
            map.put(root.val,1);
        }

        scanTree(root.left);
        scanTree(root.right);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(findMode(root));
    }

}
