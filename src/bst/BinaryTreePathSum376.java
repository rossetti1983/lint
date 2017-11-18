package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhizha on 8/19/17.
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

 A valid path is from root node to any of the leaf nodes.

 Have you met this question in a real interview? Yes
 Example
 Given a binary tree, and target = 5:

 1
 / \
 2   4
 / \
 2   3
 return

 [
 [1, 2, 2],
 [1, 4]
 ]
 */
public class BinaryTreePathSum376 {

    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        int sum = 0;
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        traversal(root, target, resList,list, sum);
        return resList;
    }

    public void traversal(TreeNode root, int target, List<List<Integer>> resList, List<Integer> list, int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(root.val + sum == target){
                List<Integer> list0 = new ArrayList<>(list);
                list0.add(root.val);
                resList.add(list0);
            }else{
                return;
            }
        }else{
            List<Integer> list0 = new ArrayList<>(list);
            list0.add(root.val);
            sum = sum + root.val;
            traversal(root.left, target, resList, list0, sum);
            traversal(root.right, target, resList, list0, sum);
        }
    }
}
