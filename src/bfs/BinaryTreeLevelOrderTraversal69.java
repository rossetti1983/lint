package bfs;

import java.util.ArrayList;
import java.util.List;

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
public class BinaryTreeLevelOrderTraversal69 {

    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        return bfsTraversal(root);
    }

    private ArrayList<ArrayList<Integer>> bfsTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> frontier = new ArrayList<>();
        frontier.add(root);
        while(frontier != null && frontier.size() > 0){
            ArrayList<Integer> level = new ArrayList<>();
            List<TreeNode> newFrontiter = new ArrayList<>();
            for(TreeNode treeNode : frontier){
                if(treeNode.left != null)
                    newFrontiter.add(treeNode.left);
                if(treeNode.right != null)
                    newFrontiter.add(treeNode.right);
                level.add(treeNode.val);
            }
            res.add(level);
            frontier = newFrontiter;
        }
        return res;
    }
}

 class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
