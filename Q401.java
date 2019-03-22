package leetcode;

import java.util.ArrayList;
import java.util.List;
//二进制手表

public class Q401 {
    //执行用时: 3 ms, 在Binary Watch的Java提交中击败了76.46% 的用户
    //内存消耗: 34.8 MB, 在Binary Watch的Java提交中击败了4.25% 的用户

    //先分上面有几个亮，下面有几个亮
    //然后用upList存储上面的所有可能结果（回溯），用downList存储下面对应的结果（回溯）
    //然后将上下两部分组合，即为结果
    List<String> res = new ArrayList<>();
    List<Integer> upList = new ArrayList<>();
    List<Integer> downList = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        int min = Math.max(0,num-6);
        for(int i=min ; i<=4 && i<=num ; i++){
            getTime(i,num-i);
            for(int m=0 ; m<upList.size() ; m++){
                String s = "";
                s+=upList.get(m)+":";
                for(int j=0 ; j<downList.size() ; j++){
                    String str = s;
                    if(downList.get(j)<10){
                        str+="0";
                    }
                    str +=downList.get(j);
                    res.add(str);
                }
            }
            upList.clear();
            downList.clear();
        }
        return res;
    }
    public void getTime(int up,int down){//分上下求出各自的时间集合
        getNum(0,up,0,4,0);
        getNum(0,down,0,6,0);
    }
    public void getNum(int num,int total,int sum,int max,int index){//回溯求出total个灯亮对应的所有结果
        if(num == total){
            if(max == 4){
                if(sum<12){
                    upList.add(sum%12);
                }
            }else {
                if(sum<60){
                    downList.add(sum%60);
                }
            }
            return;
        }

        for(int i=index ; i<max ; i++){
            sum += Math.pow(2,i);
            getNum(num+1,total,sum,max,i+1);
            sum -= Math.pow(2,i);
        }
    }
}
