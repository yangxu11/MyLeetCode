package leetcode;

import java.util.*;

public class Q508 {

    Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> treeMap = sumMap(root);
        int max = Collections.max(treeMap.values());
        for(int i : treeMap.keySet()) {
            if(map.get(i)==max) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    public Map<Integer,Integer> sumMap(TreeNode root) {
        if(root==null) return map;
        int sum = treeSum(0,root);
        if(map.containsKey(sum)) {
            map.put(sum,map.get(sum)+1);
        } else {
            map.put(sum,1);
        }
        sumMap(root.left);
        sumMap(root.right);
        return map;
    }
    public int treeSum(int sum,TreeNode root) {
        if(root==null) return sum;
        sum = sum + root.val;
        treeSum(sum,root.left);
        treeSum(sum,root.right);
        return sum;
    }

}
