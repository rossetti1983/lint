package bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhizha on 8/19/17.
 */
public class BinaryTreePostorderTraversalWORecursion68 {

    HashMap<TreeNode, Boolean> cache = new HashMap<>();

    public static void main(String[] arg){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode3;
        treeNode1.right = treeNode2;
        BinaryTreePostorderTraversalWORecursion68 binaryTreePostorderTraversalWORecursion68 = new BinaryTreePostorderTraversalWORecursion68();
        binaryTreePostorderTraversalWORecursion68.postorderTraversal(treeNode1);
    }
    /*
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        if(root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(stack!=null && stack.size()>0){
            TreeNode node = stack.peek();
            if((node.left == null && node.right == null)||(cache.containsKey(node.left) && cache.containsKey(node.right))
        ||(node.left == null && cache.containsKey(node.right))
        ||(node.right == null && cache.containsKey(node.left))){
                TreeNode node0 = stack.pop();
                list.add(node0.val);
                cache.put(node0, true);
                continue;
            }

            if(node.left!= null && !cache.containsKey(node.left)){
                stack.push(node.left);
            }else if((node.left == null && node.right != null && !cache.containsKey(node.right)) ||
                    (cache.containsKey(node.left) && node.right != null && !cache.containsKey(node.right))){
                stack.push(node.right);
            }

        }

        return list;
    }
}
