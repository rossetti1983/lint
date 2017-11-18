package bst;

/**
 * Created by zhizha on 10/30/17.
 */
public class BSTSwappedNodes691 {

    /*
     * @param : the given tree
    * @return: the tree after swapping
    */
   /* public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        TreeNode node1 = null;
        TreeNode node1Parent = null;
       bst(root, Integer.MAX_VALUE, Integer.MIN_VALUE, node1, node1Parent);
       if(node1!=null && node1Parent!=null && swap = 0){}
    }*/

    int ming = 0;
    int maxg = 0;
    int swap = 0;


    private boolean bst(TreeNode root, int max, int min, TreeNode node1, TreeNode node1Parent){
        boolean left = false;

        if(root.left != null){
            if(node1Parent!=null){
                if(root.left.val > ming && root.left.val < maxg){
                    swap(node1, node1Parent, root);
                    return true;
                }
            }
            left = bst(root.left, root.val, min, node1, node1Parent);
        }

        if(node1 != null && node1Parent != null && root.left == node1Parent){
            swap(node1, node1Parent, root);
            return true;
        }

        if(!left && node1 == null){
            node1 = root;
            ming = root.left.val;
            maxg = root.right.val;
        }

        if(root.right != null){
            if(node1Parent!=null){
                if(root.right.val > ming && root.right.val < maxg){
                    swap(node1, node1Parent, root);
                    return true;
                }
            }
            bst(root.right, max, root.val, node1, node1Parent);
        }

        if(node1 != null && node1Parent != null && root.right == node1Parent){
            swap(node1, node1Parent, root);
            return true;
        }

        boolean right = false;
        if(!right && node1 == null){
            node1 = root;
            ming = root.left.val;
            maxg = root.right.val;
        }

        if(!((root.val > min && max > root.val)&&left&&right)){
            return false;
        }
        return true;

    }

    private void swap(TreeNode node1, TreeNode node1Parent, TreeNode root) {
        if(node1Parent.left == node1){
            if(root.right.val > ming && root.right.val < maxg){
               TreeNode tmp = root.right;
               TreeNode tmpL = root.right.left;
               TreeNode tmpR = root.right.right;
               root.right.left = node1.left;
               root.right.right = node1.right;
               node1.left = tmpL;
               node1.right = tmpR;
               root.right = node1;
               node1Parent.left = tmp;
            }else{
                TreeNode tmp = root.left;
                TreeNode tmpL = root.left.left;
                TreeNode tmpR = root.left.right;
                root.left.left = node1.left;
                root.left.right = node1.right;
                node1.left = tmpL;
                node1.right = tmpR;
                root.left = node1;
                node1Parent.left = tmp;
            }
        }else{
            if(root.right.val > ming && root.right.val < maxg){
                TreeNode tmp = root.right;
                TreeNode tmpL = root.right.left;
                TreeNode tmpR = root.right.right;
                root.right.left = node1.left;
                root.right.right = node1.right;
                node1.left = tmpL;
                node1.right = tmpR;
                root.right = node1;
                node1Parent.right = tmp;
            }else{
                TreeNode tmp = root.left;
                TreeNode tmpL = root.left.left;
                TreeNode tmpR = root.left.right;
                root.left.left = node1.left;
                root.left.right = node1.right;
                node1.left = tmpL;
                node1.right = tmpR;
                root.left = node1;
                node1Parent.right = tmp;
            }
        }
        swap =1;
    }
}
