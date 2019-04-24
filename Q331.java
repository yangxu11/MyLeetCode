package leetcode;

/**
 * 验证二叉树前序序列化
 *
 * @author yx
 * @create 2019-04-24  19:59
 **/
public class Q331 {
    //节点数，比叶子尾的空节点数少1
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        int count= 1;
        for(int i=0;i<str.length;i++){
            if(count==0) return false;
            if(str[i].equals("#"))
                count--;
            else if(i!=str.length-1){
                count++;
            }
        }
        return count==0;
    }
}
