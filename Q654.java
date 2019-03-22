package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        List<Integer> list =new ArrayList<Integer>();
        for(int i=0 ; i<nums.length ; i++) {
            list.add(nums[i]);
        }
        return createTree(list);

    }
    public TreeNode createTree(List list) {
        if(list.size()==0) return null;
        int maxIndex = findMaxIndex(list);
        int max = (int)list.get(maxIndex);
        TreeNode root = new TreeNode(max);
        if(maxIndex>0) {
            root.left = createTree(list.subList(0,maxIndex));
        }
        if(maxIndex<list.size()-1) {
            root.right = createTree(list.subList(maxIndex+1,list.size()));
        }
        return root;
    }
    public int findMaxIndex(List list) {
        int index=0;
        int max = (int)list.get(0);
        for(int i=0 ; i<list.size() ; i++) {
            if(max < (int)list.get(i)) {
                max=(int)list.get(i);
                index = i;
            }
        }
        return index;
    }


}
