package dfs;

import java.util.*;

/**
 * Created by zhizha on 11/5/17.
 */
public class GrayCode411 {

    public static void main(String[] arg){
        GrayCode411 grayCode411 = new GrayCode411();
        grayCode411.grayCode(2);
    }

    /*
    * @param n: a number
    * @return: Gray code
    */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n==0){
            return res;
        }

        String init = "";
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            init +="0";
        }

        set.add(init);
        res.add(Integer.parseInt(init,2));
        dfs(init, set, res);

        // write your code here
        return res;
    }

    private void dfs(String code, Set<String> parent, List<Integer> res){
        List<String> next = getNextBinaryNumber(code);
        for(String s : next){
            if(!parent.contains(s)){
                parent.add(s);
                res.add(Integer.parseInt(s,2));
                dfs(s, parent, res);
            }
        }
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private List<String> getNextBinaryNumber(String s){
        int len = s.length();
        List<String> res = new ArrayList<>();
        for(int i= len-1 ; i>= 0; i--){
            if(s.charAt(i) == '0'){
                String news = replace(s, i, '1');
                res.add(news);
            }else{
                String news = replace(s, i, '0');
                res.add(news);
            }
        }

        return res;
    }
}
