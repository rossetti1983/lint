package bst;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhizha on 11/7/17.
 */
public class ExpressionEvaluation368 {

    public int evaluateExpression(String[] expression) {
        // write your code here
     if(expression == null || expression.length == 0){
        return 0;
    }

    Stack<Integer> main = new Stack<>();
    Stack<String> opr = new Stack<>();

        for(int i = 0 ; i < expression.length; i++){
        if(expression[i].equals("(")){
            String[] subExp = getContent(Arrays.copyOfRange(expression,i,expression.length));
            int res = evaluateExpression(subExp);
            main.push(res);
            if(main.size()>=2){
                if(!(opr.peek().equals("+")||opr.peek().equals("-"))){
                    String oprS = opr.pop();
                    int right = main.pop();
                    int left = main.pop();
                    int tmp = 0;
                    if(oprS.equals("/")){
                        tmp = left/right;
                    }else{
                        tmp = left*right;
                    }
                    main.push(tmp);
                }
            }
            i = i+subExp.length+1;
        }else if(expression[i].equals("+")||expression[i].equals("-")
                ||expression[i].equals("/")||expression[i].equals("*")){
            if(expression[i].equals("+")||expression[i].equals("-")){
                if(!opr.isEmpty() && (opr.peek().equals("+")||opr.peek().equals("-"))){
                    String oprS = opr.pop();
                    int right = main.pop();
                    int left = main.pop();
                    int tmp = 0;
                    if(oprS.equals("+")){
                        tmp = left+right;
                    }else{
                        tmp = left-right;
                    }
                    main.push(tmp);
                    opr.push(expression[i]);
                    continue;
                }
            }
            opr.push(expression[i]);

        }else{
            main.push(Integer.valueOf(expression[i]));
            if(main.size()>=2){
                if(!(opr.peek().equals("+")||opr.peek().equals("-"))){
                    String oprS = opr.pop();
                    int right = main.pop();
                    int left = main.pop();
                    int tmp = 0;
                    if(oprS.equals("/")){
                        tmp = left/right;
                    }else{
                        tmp = left*right;
                    }
                    main.push(tmp);
                }
            }
        }
    }


        while(!opr.isEmpty()){
        if(main.size()>=2){
            String oprS = opr.pop();
            int right = main.pop();
            int left = main.pop();
            int tmp = 0;
            if(oprS.equals("+")){
                tmp = left+right;
            }else{
                tmp = left-right;
            }
            main.push(tmp);
        }
    }


        return main.pop();
}

    private String[] getContent(String[] strings) {
        Stack<String> stack = new Stack<>();
        int i = 0 ;
        stack.push(strings[i++]);
        while(!stack.isEmpty()){
            if(strings[i].equals(")")){
                stack.pop();
            }

            if(strings[i].equals("(")){
                stack.push("(");
            }
            i++;
        }
        return Arrays.copyOfRange(strings,1,i-1);
    }

    private static class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }
}
