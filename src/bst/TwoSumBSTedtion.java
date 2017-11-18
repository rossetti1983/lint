package bst;

/**
 * Created by zhizha on 11/1/17.
 */
public class TwoSumBSTedtion {

    public  static void main(String[] arg){
        TreeNode root = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        l2.left = l1;
        l2.right = r3;
        root.left = l2;
        root.right = r5;
        TwoSumBSTedtion twoSumBSTedtion = new TwoSumBSTedtion();
        twoSumBSTedtion.twoSum(root,9);
    }

    /*
 * @param : the root of tree
 * @param : the target sum
 * @return: two numbers from tree which sum is n
 */


    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if(root == null){
            return null;
        }

        int count = inOrder(root, n);
        int[] res = new int[2];
        for(int i = 1; i <= count; i++){
            if(inOrder(root, n, i,0, res) == -2){
                return res;
            }

        }
        return null;
    }

    private int inOrder(TreeNode root, int target) {
        int count = 1;
        if(root.left != null){
            count += inOrder(root.left, target);
        }
        if(root.right != null){
            count += inOrder(root.right, target);
        }
        return count;
    }

    private int inOrder(TreeNode root, int target, int startIndex, int index, int[] res) {

        if(root.left != null){
            index = inOrder(root.left, target,startIndex, index, res);
            if(index == -1){
                return -1;
            }else if(index == -2){
                return -2;
            }
        }
        ++index;
        if(index == startIndex){
            if(root.val >= target){
                return -1;
            }
            res[0] = root.val;
        }else if(index > startIndex){
            if(target - res[0] == root.val){
                res[1] = root.val;
                return -2;
            }else if(root.val > target - res[0]){
                return -1;
            }
        }
        if(root.right != null){
            index = inOrder(root.right, target,startIndex, index, res);
            if(index == -1){
                return -1;
            }else if(index == -2){
                return -2;
            }
        }
        return index;
    }
}
