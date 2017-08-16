package bst;

/**
 * Created by zhizha on 8/13/17.
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 * Have you met this question in a real interview? Yes
 * Example
 * An example:
 * <p>
 * 2
 * / \
 * 1   4
 * / \
 * 3   5
 */
public class ValidateBinarySearchTree95 {

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return inOrderTraversal(root, null, null);
    }

    private boolean inOrderTraversal(TreeNode root, Integer rightBound, Integer leftBound) {
        if (root == null)
            return true;
        if (leftBound == null || root.val > leftBound) {
            if (rightBound == null || root.val < rightBound) {
                if (root.left == null || root.val > root.left.val) {
                    if (root.left != null) {
                        if (inOrderTraversal(root.left, root.val, leftBound)) {
                            if (root.right == null || root.val < root.right.val) {
                                if (root.right != null) {
                                    return inOrderTraversal(root.right, rightBound, root.val);
                                }
                                return true;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        if (root.right == null || root.val < root.right.val) {
                            if (root.right != null) {
                                return inOrderTraversal(root.right, rightBound, root.val);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}

