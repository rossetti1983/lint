package bst;

/**
 * Created by zhizha on 10/29/17.
 */
public class LowestCommonAncestor {

    public static void main(String[] arg) {

        TreeNode root = new TreeNode(101);

        TreeNode a1 = new TreeNode(12);
        root.left = a1;
        TreeNode a2 = new TreeNode(13);
        a1.left = a2;
        TreeNode a3 = new TreeNode(14);
        a2.left = a3;
        TreeNode a4 = new TreeNode(15);
        a3.left = a4;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode node = lowestCommonAncestor.lowestCommonAncestor(root, a3, a4);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) return null;
        if (root == A || root == B) return root;
        TreeNode lch = lowestCommonAncestor(root.left, A, B);
        TreeNode rch = lowestCommonAncestor(root.right, A, B);
        if (lch != null && rch != null) return root;
        return lch == null ? rch : lch;
    }
}
