package leetcode;

public class Q874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int state1 = 1;//1上，-1下
        int state2 = 0;//-1左，1右
        int[][] states = {{1,0},{0,1},{-1,0},{0,-1}};
        int[] state = {1,0};
        int pos = 0;
        int[] position = new int[2];
        position[0] = 0;
        position[1] = 0;
        int max = 0;
        for(int i=0 ; i<commands.length ; i++){
            if(commands[i] == -1){
                if(pos ==3 ){
                    state = states[0];
                    pos = 0;
                } else {
                    state = states[++pos];
                }
            } else if(commands[i] == -2) {
                if(pos ==0 ){
                    state = states[3];
                    pos = 3;
                } else {
                    state = states[--pos];
                }
            } else {
                int flag = 0;
                for(int j=1 ; j<=commands[i] ; j++){
                    position[0] = position[0] + state[1];
                    position[1] = position[1] + state[0];

                    for(int[] ob : obstacles) {
                        if(position[0] == ob[0] && position[1] == ob[1]){
                            position[0] = position[0] - state[1];
                            position[1] = position[1] - state[0];
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1) break;
                }
                max = Math.max(position[0]*position[0] + position[1]*position[1],max);
            }
        }
        return max;
    }
}
