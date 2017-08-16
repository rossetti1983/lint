package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 8/14/17.
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Have you met this question in a real interview? Yes
 Example
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.


 */
public class HouseRobberIII535 {


    Map<TreeNode, Integer> cache = new HashMap<>();
    /*
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        if(cache.containsKey(root)){
            return cache.get(root);
        }
        int leftGrandChild = 0;
        if(root.left != null) {
            leftGrandChild = houseRobber3(root.left.left) + houseRobber3(root.left.right);
        }
        int rightGrandChild = 0;
        if(root.right != null){
            rightGrandChild = houseRobber3(root.right.left) + houseRobber3(root.right.right);
        }
        int v1 = root.val + leftGrandChild + rightGrandChild;
        int v2 = houseRobber3(root.left) + houseRobber3(root.right);
        int res = Math.max(v1,v2);
        cache.put(root, res);
        return res;
    }
}


 class TreeNode {
   public int val;
   public TreeNode left, right;
   public TreeNode(int x) { val = x; }
  }
