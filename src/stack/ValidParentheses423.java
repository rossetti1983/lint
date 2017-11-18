package stack;

import java.util.*;

/**
 * Created by zhizha on 8/15/17.
 */
public class ValidParentheses423 {

    /**
     *
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     Have you met this question in a real interview? Yes
     Example
     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if(s == null || s.equals(""))
            return true;
        // Write your code here
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            s1.push(String.valueOf(s.charAt(i)));
        }

        Map<String,String> cache = new HashMap<>();
        cache.put(")","(");
        cache.put("]","[");
        cache.put("}","{");

        while(!s1.empty()){
            String ss1 = s1.pop();
            if(!s2.empty()) {
                String ss2 = s2.peek();
                if(ss1.equals(cache.get(ss2))){
                    s2.pop();
                }else{
                    s2.push(ss1);
                }
            }else{
                s2.push(ss1);
            }
        }
        return s2.empty();
    }
}
