package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/6/17.
 */
public class UniqueBinarySearchTreesII164 {

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        // write your code here

        int left = 1;
        int right = n;

        return dfsBuild(left, right);

    }

    private List<TreeNode> dfsBuild(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }

        for(int i = left; i<=right; i++){
            List<TreeNode> tleft = dfsBuild(left, i-1);
            List<TreeNode> tright = dfsBuild(i+1, right);
            for(TreeNode lnode:tleft){
                for(TreeNode rnode:tright){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = lnode;
                    treeNode.right = rnode;
                    res.add(treeNode);
                }
            }

        }

        return res;
    }
}
