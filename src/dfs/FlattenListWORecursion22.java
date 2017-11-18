package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhizha on 8/19/17.
 */
public class FlattenListWORecursion22 {


    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if(nestedList == null){
            return list;
        }else{
            Stack<NestedInteger> stack = new Stack<>();
            for(int i = 0; i< nestedList.size(); i++){
                stack.push(nestedList.get(i));
            }
            while(stack.size()>0){
                NestedInteger ni = stack.peek();
                if(ni.isInteger()){
                    list.add(ni.getInteger());
                }else{
                    ni = stack.pop();
                    for(NestedInteger nii : ni.getList()){
                    stack.push(nii);
                    }
                }
            }
        }
        return list;
    }
}

 interface NestedInteger {

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
