package stack;

import java.util.Stack;

/**
 * Created by zhizha on 10/15/17.
 */
public class ImplementQueuebyTwoStacks40 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public ImplementQueuebyTwoStacks40() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            if(stack1.isEmpty()){
                return stack2.pop();
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            if(stack1.isEmpty()){
                return stack2.peek();
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
}
