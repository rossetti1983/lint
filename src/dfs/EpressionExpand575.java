package dfs;

import java.util.Stack;

/**
 * Created by zhizha on 11/5/17.
 */
public class EpressionExpand575 {

    public static void main(String[] arg){
        EpressionExpand575 epressionExpand575 = new EpressionExpand575();
        epressionExpand575.expressionExpand("3[2[ad]3[pf]]xyz");
    }
    /*
    * @param s: an expression includes numbers, letters and brackets
    * @return: a string
    */
    public String expressionExpand(String s) {
        // write your code here
        if(s == null || s.equals("")){
            return s;
        }

        s = dfs(s);
        return s;
    }

    private String dfs(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < s.length(); i++){
            if( s.charAt(i)-'0' >= 0 &&  s.charAt(i)-'0' <= 9 ){
                int index = i+s.substring(i).indexOf("[");
                int rep = Integer.valueOf(s.substring(i, index));
                int endIndex = getInnerStr(s.substring(index));
                String str = dfs(s.substring(index+1,index + endIndex));
                for(int j = 0 ; j < rep; j++){
                    sb.append(str);
                }
                i = index+endIndex;
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private int getInnerStr(String substring) {
        Stack<Character> stack = new Stack<>();
        stack.push(substring.charAt(0));
        int index = 1;
        while(!stack.isEmpty()){
            if(substring.charAt(index) == '['){
                stack.push('[');
            }else if(substring.charAt(index) == ']'){
                stack.pop();
            }
            index ++;
        }
        return index-1;
    }
}
