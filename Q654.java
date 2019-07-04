package leetcode;

public class Q654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        return getTree(nums,0,nums.length-1);
    }

    public TreeNode getTree(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int index = start;
        for(int i=start ; i<=end ; i++){
            if(nums[i]>nums[index]){
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = getTree(nums,start,index-1);
        root.right = getTree(nums,index+1,end);
        return root;
    }


}
