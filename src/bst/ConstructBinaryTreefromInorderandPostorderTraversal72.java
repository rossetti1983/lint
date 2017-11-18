package bst;

import java.util.Arrays;

/**
 * Created by zhizha on 10/27/17.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal72 {

    /*
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || inorder.length == 0){
            return null;
        }

        return buildT(inorder, postorder);

    }

    public TreeNode buildT(int[] inorder, int[] postorder){
        if(inorder == null || inorder.length == 0){
            return null;
        }
        int rootValue = postorder[postorder.length-1];
        int rootInOrder = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                rootInOrder = i;
                break;
            }
        }
        TreeNode treeNode = new TreeNode(postorder[postorder.length-1]);
        treeNode.left = buildT(Arrays.copyOfRange(inorder, 0, rootInOrder),
                Arrays.copyOfRange(postorder, 0, rootInOrder));

        treeNode.right = buildT(Arrays.copyOfRange(inorder, rootInOrder+1, inorder.length),
                Arrays.copyOfRange(postorder, rootInOrder, postorder.length-1));

        return treeNode;
    }
}
