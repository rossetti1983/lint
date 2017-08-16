package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 8/13/17.
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 Have you met this question in a real interview? Yes
 Example
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class BinaryTreeZigzagLevelOrderTraversal71 {

    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        return bfsTraversal(root);
    }

    private ArrayList<ArrayList<Integer>> bfsTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> frontier = new ArrayList<>();
        boolean alt = false;
        frontier.add(root);
        while(frontier != null && frontier.size() > 0){
            ArrayList<Integer> level = new ArrayList<>();
            List<TreeNode> newFrontiter = new ArrayList<>();
            for(TreeNode treeNode: frontier){
                if (treeNode.left != null)
                    newFrontiter.add(treeNode.left);
                if (treeNode.right != null)
                    newFrontiter.add(treeNode.right);
            }
            if(!alt) {
                for (int i = 0; i < frontier.size(); i++) {
                    TreeNode treeNode = frontier.get(i);
                    level.add(treeNode.val);
                }
            }else{
                for (int i = frontier.size() - 1; i >= 0 ; i--) {
                    TreeNode treeNode = frontier.get(i);
                    level.add(treeNode.val);
                }
            }
            alt = !alt;
            res.add(level);
            frontier = newFrontiter;
        }
        return res;
    }
}
