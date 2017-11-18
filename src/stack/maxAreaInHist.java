package stack;

import java.util.Stack;

/**
 * Created by zhizha on 10/24/17.
 */
public class maxAreaInHist {

    public static void main(String[] arg){
        maxAreaInHist maxAreaInHist = new maxAreaInHist();
        maxAreaInHist.maxAreaInHist(new int[]{2,0,3});
    }

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}
