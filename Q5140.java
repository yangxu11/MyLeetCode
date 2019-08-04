package leetcode;

/**
 * 字母版上的路径
 *
 * @author yx
 * @create 2019-07-28  10:57
 **/
public class Q5140 {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        if(target.length()==0) return res.toString();
        int prex=0;
        int prey=0;
        char prec = 'a';

        for(int i=0 ; i<target.length() ; i++){
            char c = target.charAt(i);
            int index = c-'a';
            int x = index/5;
            int y = index%5;
            if(prec=='z'){
                if(x>prex){
                    for(int j=0 ; j<x-prex ; j++){
                        res.append("D");
                    }
                }else{
                    for(int j=0 ; j<prex-x ; j++){
                        res.append("U");
                    }
                }

                if(y>prey){
                    for(int j=0 ; j<y-prey ; j++){
                        res.append("R");
                    }
                }else{
                    for(int j=0 ; j<prey-y ; j++){
                        res.append("L");
                    }
                }
            } else if(c=='z'){

                if(y>prey){
                    for(int j=0 ; j<y-prey ; j++){
                        res.append("R");
                    }
                }else{
                    for(int j=0 ; j<prey-y ; j++){
                        res.append("L");
                    }
                }

                if(x>prex){
                    for(int j=0 ; j<x-prex ; j++){
                        res.append("D");
                    }
                }else{
                    for(int j=0 ; j<prex-x ; j++){
                        res.append("U");
                    }
                }


            } else{
                if(x>prex){
                    for(int j=0 ; j<x-prex ; j++){
                        res.append("D");
                    }
                }else{
                    for(int j=0 ; j<prex-x ; j++){
                        res.append("U");
                    }
                }

                if(y>prey){
                    for(int j=0 ; j<y-prey ; j++){
                        res.append("R");
                    }
                }else{
                    for(int j=0 ; j<prey-y ; j++){
                        res.append("L");
                    }
                }
            }

            res.append("!");
            prex = x;
            prey = y;
            prec = c;
        }

        return res.toString();
    }

}
