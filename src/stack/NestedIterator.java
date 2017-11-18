package stack;

/**
 * Created by zhizha on 10/15/17.
 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> iterator = null;
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        build(nestedList);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    private void build(List<NestedInteger> nestedList) {
        Iterator<NestedInteger> iterator = nestedList.iterator();
        while(iterator.hasNext()){
            NestedInteger nestedInteger = iterator.next();
            if(nestedInteger.isInteger()){
                stack1.push(nestedInteger.getInteger());
            }else{
                build(nestedInteger.getList());
            }
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if(!stack2.isEmpty())
            return stack2.pop();
        else
            return null;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return !stack2.isEmpty();
    }

    @Override
    public void remove() {
    }


     private static interface NestedInteger {

              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}

