package dfs;

import apple.laf.JRSUIUtils;

/**
 * Created by zhizha on 8/13/17.
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.

 Here we use the right pointer in TreeNode as the next pointer in ListNode.

 Notice

 Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

 Have you met this question in a real interview? Yes
 Example
 1
 \
 1          2
 / \          \
 2   5    =>    3
 / \   \          \
 3   4   6          4
 \
 5
 \
 6
 */
public class FlattenBinaryTreetoLinkedList453 {

    public static void main(String[] arg){
        TreeNode treeNode = new TreeNode(98);
        TreeNode treeNode1 = new TreeNode(97);

        treeNode.left = treeNode1;
        treeNode.right = null;
        FlattenBinaryTreetoLinkedList453 flattenBinaryTreetoLinkedList453 = new FlattenBinaryTreetoLinkedList453();
        flattenBinaryTreetoLinkedList453.flatten(treeNode);
    }
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return:
     */
    public void flatten(TreeNode root) {
        // write your code here
        preOrderTraversal(root);
    }

    private TreeNode preOrderTraversal(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode mostLeft = preOrderTraversal(root.left);
        TreeNode mostRight = preOrderTraversal(root.right);
        if(mostLeft != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            mostLeft.right = tmp;
        }
        root.left = null;
        if(mostRight == null){
            mostRight = mostLeft;
        }
        return mostRight;
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
