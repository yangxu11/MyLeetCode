package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 餐盘栈
 *
 * @author yx
 * @create 2019-08-25  11:42
 **/
public class Q5165 {
    class DinnerPlates {

        int c;
        List<int[]> plats = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();


        public DinnerPlates(int capacity) {
            this.c = capacity;
        }

        public void push(int val) {
            if(plats.isEmpty()){
                int[] nums = new int[c];
                int index = 1;
                nums[index-1] = val;
                plats.add(nums);
                indexs.add(index);
            } else{
                int index = -1;
                for(int i=0 ; i<indexs.size() ; i++){
                    if(indexs.get(i)<c){
                        index = i;
                        break;
                    }
                }
                if(index==-1){
                    int[] nums = new int[c];
                    int i = 0;
                    nums[i++] = val;
                    plats.add(nums);
                    indexs.add(i);
                } else{
                    int[] nums = plats.get(index);
                    int x = indexs.get(index);
                    nums[x++] = val;
                    plats.set(index,nums);
                    indexs.set(index,x);
                }
            }
        }

        public int pop() {
            int pos = -1;
            for(int i=indexs.size()-1 ; i>=0 ; i--){
                if(indexs.get(i)>0){
                    pos = i;
                    break;
                }
            }
            if(pos==-1){
                return -1;
            }
            int[] nums = plats.get(pos);
            int index = indexs.get(pos);
            int res = nums[index-1];
            nums[index-1] = 0;
            index--;
            if(index==0){
                plats.remove(plats.size()-1);
                indexs.remove(indexs.size()-1);
            } else{
                plats.set(pos,nums);
                indexs.set(pos,index);
            }
            return res;
        }

        public int popAtStack(int index) {
            int pos = indexs.get(index);
            if(pos==0){
                return -1;
            }
            int[] nums = plats.get(index);
            int res = nums[pos-1];
            nums[pos-1] = 0;
            pos--;
            plats.set(index,nums);
            indexs.set(index,pos);

            return res;
        }
    }
}
