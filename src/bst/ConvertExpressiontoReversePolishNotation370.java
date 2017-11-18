package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhizha on 11/7/17.
 */
public class ConvertExpressiontoReversePolishNotation370 {

    public List<String> convertToRPN(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return new ArrayList<>();
        }

        List<String> main = new ArrayList<>();
        Stack<String> opr = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                String[] subExp = getContent(Arrays.copyOfRange(expression, i, expression.length));
                List<String> res = convertToRPN(subExp);
                main.addAll(res);
                if (main.size() >= 2) {
                    if (!(opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String opers = opr.pop();
                        main.add(opers);
                    }
                }
                i = i + subExp.length + 1;
            } else if (expression[i].equals("+") || expression[i].equals("-")
                    || expression[i].equals("/") || expression[i].equals("*")) {
                if (expression[i].equals("+") || expression[i].equals("-")) {
                    if (!opr.isEmpty() && (opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String opers = opr.pop();
                        main.add(opers);
                        opr.push(expression[i]);
                        continue;
                    }
                }
                opr.push(expression[i]);

            } else {
                main.add((expression[i]));
                if (main.size() >= 2) {
                    if (!(opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String opers = opr.pop();
                        main.add(opers);
                    }
                }
            }
        }


        while (!opr.isEmpty()) {
                String opers = opr.pop();
                main.add(opers);
        }


        return main;
    }

    private String[] getContent(String[] strings) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        stack.push(strings[i++]);
        while (!stack.isEmpty()) {
            if (strings[i].equals(")")) {
                stack.pop();
            }

            if (strings[i].equals("(")) {
                stack.push("(");
            }
            i++;
        }
        return Arrays.copyOfRange(strings, 1, i - 1);
    }


}
