package bst;

/**
 * Created by zhizha on 11/1/17.
 */
public class RemoveNodeinBinarySearchTree87 {

    public  static void main(String[] arg){
        TreeNode root = new TreeNode(1001);
        TreeNode l1 = new TreeNode(92);
        TreeNode l2 = new TreeNode(81);
        TreeNode l3 = new TreeNode(75);
        TreeNode l4 = new TreeNode(41);
        TreeNode r5 = new TreeNode(65);

        root.left = l1;
        l1.left = l2;
        l2.left = l3;
        l3.left = l4;
        l4.right = r5;

        RemoveNodeinBinarySearchTree87 removeNodeinBinarySearchTree87 = new RemoveNodeinBinarySearchTree87();
        removeNodeinBinarySearchTree87.removeNode(root, 92);
    }
    /*
 * @param root: The root of the binary search tree.
 * @param value: Remove the node with given value.
 * @return: The root of the binary search tree after removal.
 */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null){
            return root;
        }

        TreeNode targetNode = inorder(root, value);
        if(targetNode == null){
            return root;
        }
        TreeNode leftMostNode = null;
        if(targetNode == root){
            if(root.right!=null){
            leftMostNode = inorder(root.right);
            }
        }else {

            if (targetNode.right != null && targetNode.right.val == value) {
                if (targetNode.right != null && targetNode.right.right != null) {
                    leftMostNode = inorder(targetNode.right.right);
                }
            } else {
                if (targetNode.left != null && targetNode.left.right != null) {
                    leftMostNode = inorder(targetNode.left.right);
                }
            }
        }

        if(root.val == value){
            TreeNode tmp = root.left;
            if(root.right != null) {
                root = root.right;
                if (leftMostNode != null) {
                    leftMostNode.left = tmp;
                }
            }else {
                root = tmp;
            }
        }else{
            if(targetNode.right != null && targetNode.right.val == value){
                TreeNode tmp = targetNode.right.left;
                if(targetNode.right.right != null) {
                    targetNode.right = targetNode.right.right;
                    if (leftMostNode != null) {
                        leftMostNode.left = tmp;
                    }
                }else{
                    targetNode.right = tmp;
                }
            }else{
                TreeNode tmp = targetNode.left.left;
                if(targetNode.left.right != null) {
                targetNode.left = targetNode.left.right;
                if(leftMostNode != null) {
                    leftMostNode.left = tmp;
                }}else{
                    targetNode.left = tmp;
                }
            }
        }

        return root;

    }

    TreeNode inorder(TreeNode root, int target){

        if(root.left != null){
            if(root.left.val == target){
                return root;
            }
            TreeNode left = null;
            left = inorder(root.left, target);
            if(left != null){
                return left;
            }
        }



        if(root.right != null){
            if(root.right.val == target){
                return root;
            }
            TreeNode right = null;
            right = inorder(root.right, target);
            if(right != null){
                return right;
            }
        }

        if(root.val == target){
            return root;
        }
        return null;
    }

    TreeNode inorder(TreeNode root){

        if(root == null){
            return null;
        }

        if(root.left != null){
           return inorder(root.left);
        }

        return root;
    }
}
