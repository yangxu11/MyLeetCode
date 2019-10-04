package leetcode.huawei;

/**
 * 2
 *
 * @author yx
 * @create 2019-09-25  19:18
 **/
public class Q2 {
    static int[] nums = {1,2,3,4,5,6};
    static String[] operations={"Q 1 6","U 2 6","U 4 3","Q 2 4","Q 1 2","U 1 3","U 2 1","Q 1 3"};
    public static void main(String[] args) {
        getAvg(operations);
    }

    public static void getAvg(String[] operations){

        for(String ops : operations){
            String[] strs = ops.split(" ");
            if(ops.startsWith("Q")){
                int start = Integer.valueOf(strs[1])-1;
                int end = Integer.valueOf(strs[2])-1;

                int sum = 0;
                for(int i=start ; i<=end ; i++){
                    sum += nums[i];
                }
                System.out.println(sum/(end-start+1));
            } else{
                int index = Integer.valueOf(strs[1])-1;
                int num = Integer.valueOf(strs[2]);
                nums[index] += num;
            }
        }

    }

}
