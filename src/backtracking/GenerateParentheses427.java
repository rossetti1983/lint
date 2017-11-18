package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/4/17.
 */
public class GenerateParentheses427 {

    public static void main(String[] arg){
        GenerateParentheses427 generateParentheses427 = new GenerateParentheses427();
        generateParentheses427.generateParenthesis(3);
    }
    /*
    * @param n: n pairs
    * @return: All combinations of well-formed parentheses
    */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(n<1){
            return res;
        }else{
            rr(n, "",0,0, res);
        }
        return res;
    }

    public void rr(int n, String s, int pn, int pne, List<String> res){
        if(pn<pne || pn > n || pne > n){
            return;
        }else{
           if(n==pn && pn==pne){
               res.add(s);
           }else{
               String ss = s + "(";
               rr(n,ss,pn+1, pne, res);
               ss = s+")";
               rr(n,ss,pn, pne+1, res);
           }
        }
    }
}
