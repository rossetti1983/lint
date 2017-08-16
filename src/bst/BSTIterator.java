package bst;


/*  Example of iterate a tree:
  BSTIterator iterator = new BSTIterator(root);
  while (iterator.hasNext()) {
     TreeNode node = iterator.next();
     do something for node
  }*/

import java.util.ArrayList;
import java.util.List;

/**
 * Design an iterator over a binary search tree with the following rules:

 Elements are visited in ascending order (i.e. an in-order traversal)
 next() and hasNext() queries run in O(1) time in average.
 Have you met this question in a real interview? Yes
 Example
 For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
 1      11
 \       \
 6       12
 */

public class BSTIterator {

    public static void main(String[] arg){
        TreeNode treeNode = new TreeNode(-1);
        BSTIterator iterator = new BSTIterator(treeNode);
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
        }
    }
    //@param root: The root of binary tree.
    int len = 0;
    int currenIndex = 0;
    List<TreeNode> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        // write your code here
        inOrderTraversal(root, list);
        len = list.size();
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> list) {
        if(root == null)
            return;
        inOrderTraversal(root.left, list);
        list.add(root);
        inOrderTraversal(root.right, list);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if(currenIndex<len)
            return true;
        return false;
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        return list.get(currenIndex++);
    }


}
/**
 * Definition of TreeNode: */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
