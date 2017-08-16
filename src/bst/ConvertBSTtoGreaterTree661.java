package bst;

/**
 * Created by zhizha on 8/13/17.
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Have you met this question in a real interview? Yes
 Example
 Given a binary search Tree ｀{5,2,3}｀:

 5
 /   \
 2     13
 Return the root of new tree

 18
 /   \
 20     13
 */
public class ConvertBSTtoGreaterTree661 {

    int value = 0;
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        descOrderTraversal(root);
        return root;
    }

    private void descOrderTraversal(TreeNode root) {

        if(root == null)
            return;
        descOrderTraversal(root.right);
        value = value + ((root.right != null)?root.right.val:0);
        root.val = root.val + value;
        value = root.val;
        descOrderTraversal(root.left);
        value = value + ((root.left != null)?root.left.val:0);
    }
}
