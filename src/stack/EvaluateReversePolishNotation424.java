package stack;

import java.util.Stack;

/**
 * Created by zhizha on 8/15/17.
 */
public class EvaluateReversePolishNotation424 {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Have you met this question in a real interview? Yes
     Example
     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
        Stack<String> s1 = new Stack();
        for(int i = 0; i< tokens.length; i++){
            if(tokens[i].equals("+")){
                String one = s1.pop();
                String two = s1.pop();
                int sum = Integer.valueOf(one) + Integer.valueOf(two);
                s1.push(String.valueOf(sum));
            }
            else if(tokens[i].equals("-")){
                String one = s1.pop();
                String two = s1.pop();
                int diff = Integer.valueOf(two) - Integer.valueOf(one);
                s1.push(String.valueOf(diff));
            }
            else if(tokens[i].equals("*")){
                String one = s1.pop();
                String two = s1.pop();
                int product = Integer.valueOf(two) * Integer.valueOf(one);
                s1.push(String.valueOf(product));
            }else if(tokens[i].equals("/")){
                String one = s1.pop();
                String two = s1.pop();
                int div = Integer.valueOf(two) / Integer.valueOf(one);
                s1.push(String.valueOf(div));
            }else{
                s1.push(tokens[i]);
            }
        }
        return Integer.valueOf(s1.pop());
    }
}
