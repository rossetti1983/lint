package bfs;

import java.util.*;

/**
 * Created by zhizha on 8/13/17.
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 Have you met this question in a real interview? Yes
 Example
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class BinaryTreeLevelOrderTraversalDFSsolution69 {

    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfsTraversal(root, 0);
        int len = levelMap.size();
        for(int i = 0; i < len; i++){
            ArrayList<Integer> list = levelMap.get(i);
            res.add(list);
        }
        return res;
    }

    Map<Integer, ArrayList<Integer>> levelMap = new HashMap<>();

    private void dfsTraversal(TreeNode root, int level) {
        if(root==null){
            return;
        }
        if(levelMap.containsKey(level)){
            levelMap.get(level).add(root.val);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            levelMap.put(level,list);
        }
        dfsTraversal(root.left, level+1);
        dfsTraversal(root.right, level+1);
    }
}

