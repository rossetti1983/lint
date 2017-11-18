package stack;

import java.util.Stack;

/**
 * Created by zhizha on 10/15/17.
 * Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * s = abc3[a] return abcaaa
 * s = 3[abc] return abcabcabc
 * s = 4[ac]dy, return acacacacdy
 * s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
 */
public class ExpressionExpand575 {

    public static void main(String[] arg) {
        ExpressionExpand575 expressionExpand575 = new ExpressionExpand575();
        expressionExpand575.expressionExpand("3[2[ad]3[pf]]xyz");
    }

    /*
    * @param s: an expression includes numbers, letters and brackets
    * @return: a string
    */
    public String expressionExpand(String s) {
        // write your code here
        if (s == null || s.trim().equals("")) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        build(s, sb, 1);
        return sb.toString();
    }

    private String build(String s, StringBuffer sb, int times) {
        StringBuffer ssb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                int startindex = s.substring(i).indexOf("[");
                int subtimes = Integer.valueOf(s.substring(i, i + startindex));
                Stack<String> stack = new Stack<>();
                stack.push("[");
                int endIndex = startindex;
                while (!stack.isEmpty()) {
                    endIndex++;
                    if (s.charAt(endIndex) == '[') {
                        stack.push("[");
                    } else if (s.charAt(endIndex) == ']') {
                        stack.pop();
                    }
                }
                String ss = s.substring(i + startindex + 1, i + endIndex);
                build(ss, sb, subtimes);

                i = i + endIndex;
            } else {
                ssb.append(s.charAt(i));
            }
        }

        for(int i = 0; i < times; i++){
            sb.append(ssb);
        }

        return sb.toString();
    }
}
