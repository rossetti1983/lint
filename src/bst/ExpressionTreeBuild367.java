package bst;

import com.sun.tools.corba.se.idl.InterfaceGen;
import stack.ExpressionExpand575;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by zhizha on 10/30/17.
 */
public class ExpressionTreeBuild367 {

    public static void main(String[] arg) {
        ExpressionTreeBuild367 ExpressionTreeBuild367 = new ExpressionTreeBuild367();
        ExpressionTreeBuild367.build(new String[]{"(", "(", "998", "/", "499", "*", "(", "396", "/", "(", "3", "+", "3", "+", "3", ")", "-", "5", ")", ")", "/", "6", "-", "1", "/", "1", ")", "/", "3"});
    }

    /*
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }

        Stack<ExpressionTreeNode> main = new Stack<>();
        Stack<String> opr = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                String[] subExp = getContent(Arrays.copyOfRange(expression, i, expression.length));
                ExpressionTreeNode treeNode = build(subExp);
                main.push(treeNode);
                if (main.size() >= 2) {
                    if (!(opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String oprS = opr.pop();
                        ExpressionTreeNode right = main.pop();
                        ExpressionTreeNode left = main.pop();
                        ExpressionTreeNode newNode = new ExpressionTreeNode(oprS);
                        newNode.left = left;
                        newNode.right = right;
                        main.push(newNode);
                    }
                }
                i = i + subExp.length + 1;
            } else if (expression[i].equals("+") || expression[i].equals("-")
                    || expression[i].equals("/") || expression[i].equals("*")) {
                if (expression[i].equals("+") || expression[i].equals("-")) {
                    if (!opr.isEmpty() && (opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String oprS = opr.pop();
                        ExpressionTreeNode right = main.pop();
                        ExpressionTreeNode left = main.pop();
                        ExpressionTreeNode newNode = new ExpressionTreeNode(oprS);
                        newNode.left = left;
                        newNode.right = right;
                        main.push(newNode);
                        opr.push(expression[i]);
                        continue;
                    }
                }
                opr.push(expression[i]);

            } else {
                main.push(new ExpressionTreeNode(expression[i]));
                if (main.size() >= 2) {
                    if (!(opr.peek().equals("+") || opr.peek().equals("-"))) {
                        String oprS = opr.pop();
                        ExpressionTreeNode right = main.pop();
                        ExpressionTreeNode left = main.pop();
                        ExpressionTreeNode newNode = new ExpressionTreeNode(oprS);
                        newNode.left = left;
                        newNode.right = right;
                        main.push(newNode);
                    }
                }
            }
        }


        while (!opr.isEmpty()) {
            if (main.size() >= 2) {
                String oprS = opr.pop();
                ExpressionTreeNode right = main.pop();
                ExpressionTreeNode left = main.pop();
                ExpressionTreeNode newNode = new ExpressionTreeNode(oprS);
                newNode.left = left;
                newNode.right = right;
                main.push(newNode);
            }
        }


        return main.pop();
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




/*    private String[] removeBracket(String[] expression) {
        int j = 0;
        for(int i = 0; i < expression.length; i++){
            if(expression[i].equals("(") || expression[i].equals(")")){
                j++;
            }
        }
        String[] ex = new String[expression.length-j];
        j = 0;
        for(int i = 0; i < expression.length; i++){
            if(expression[i].equals("(") || expression[i].equals(")")){
                continue;
            }else{
                ex[j++] = expression[i];
            }
        }

        return ex;
    }


    public ExpressionTreeNode buildT(String[] inorder, String[][] postorder){
        if(inorder == null || inorder.length == 0){
            return null;
        }
        String rootValue = postorder[postorder.length-1][0];
        int rootInOrder = Integer.valueOf(postorder[postorder.length-1][1]);

        ExpressionTreeNode treeNode = new ExpressionTreeNode(rootValue);
        treeNode.left = buildT(Arrays.copyOfRange(inorder, 0, rootInOrder),
                Arrays.copyOfRange(postorder, 0, rootInOrder));

        String[][] nPostorder = Arrays.copyOfRange(postorder, rootInOrder, postorder.length-1);
        for(String[] s : nPostorder){
            s[1] = String.valueOf(Integer.valueOf(s[1]) - (rootInOrder+1));
        }
        treeNode.right = buildT(Arrays.copyOfRange(inorder, rootInOrder+1, inorder.length),nPostorder
        );

        return treeNode;
    }

    private String[][] convert2PostOrder(String[] expression) {
        Stack<String[]> a = new Stack<>();
        Stack<String[]> operator = new Stack<>();
        Stack<String[]> bracket = new Stack<>();
        Stack<String[]> bracketOpr = new Stack<>();
        int i = 0;

        int index = 0 ;
        for(String s : expression){
            if(isNumber(s)){
                i ++ ;
                a.push(new String[]{s,String.valueOf(index)});
                if(!bracket.isEmpty()){
                    if(!bracketOpr.isEmpty() && (bracketOpr.peek()[0].equals("/") || bracketOpr.peek()[0].equals("*"))){
                        a.push(bracketOpr.pop());
                    }}else{
                    if(!operator.isEmpty() && (operator.peek()[0].equals("/") || operator.peek()[0].equals("*"))){
                        a.push(operator.pop());
                    }
                }

            }else{
                if(s.equals("/") || s.equals("*")){
                    if(!bracket.isEmpty()){
                        bracketOpr.push(new String[]{s, String.valueOf(index)});
                    }else {
                        operator.push(new String[]{s, String.valueOf(index)});
                    }
                }else if(s.equals("(") || s.equals(")")){

                    if(s.equals(")")){
                        if(bracket.peek()[0].equals("(")){
                            bracket.pop();
                            while(!bracketOpr.isEmpty()) {
                                a.push(bracketOpr.pop());
                            }
                        }
                    }else{
                        bracket.push(new String[]{s,String.valueOf(index)});
                    }
                    //a.push(new String[]{s,String.valueOf(index)});
                }else{
                    if(!bracket.isEmpty()){
                        bracketOpr.push(new String[]{s, String.valueOf(index)});
                    }else {
                        operator.push(new String[]{s, String.valueOf(index)});
                    }
                }
            }
            if(!(s.equals("(") || s.equals(")"))){
                index++;
            }

        }

        while(!operator.isEmpty()){
            a.push(operator.pop());
        }

        String[][] post = new String[a.size()][2];
        StringBuffer sb =new StringBuffer();
        int j = a.size()-1;
        while(!a.isEmpty()){
            post[j--]=a.pop();
        }

        return post;
    }

    private boolean isNumber(String s){
        return s.charAt(0)-'0'<=9 && s.charAt(0)-'0'>= 0;
    }*/

    private static class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;

        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }
}
