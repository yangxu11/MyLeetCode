package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 *
 * @author yx
 * @create 2019-03-30  11:22
 **/
public class Q133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //bfs,递归,使用map记录克隆过的节点
    class Solution {
        Map<Node, Node> map = new HashMap();
        public Node cloneGraph(Node node) {
            if(node==null) return null;
            List<Node> list = new ArrayList<>();
            Node res = new Node(node.val,list);
            if(!map.containsKey(node)) map.put(node,res);
            for(Node neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    list.add(map.get(neighbor));
                } else{
                    list.add(cloneGraph(neighbor));
                }
            }
            return res;
        }
    }
}
