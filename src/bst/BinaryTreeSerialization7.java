package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/28/17.
 */
public class BinaryTreeSerialization7 {


    public static void main(String[] arg){
        BinaryTreeSerialization7 binaryTreeSerialization7 = new BinaryTreeSerialization7();
        binaryTreeSerialization7.deserialize("");
    }
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        // write your code here
        List<TreeNode> frontier = new ArrayList<>();
        frontier.add(root);
        String s = "";
        while(frontier.size()>0){
            List<TreeNode> newfrontier = new ArrayList<>();
            int size = frontier.size();
            int empty = 0;
            for(TreeNode node : frontier){
                if(node.val == -1){
                    s = s.equals("") ?  (s+"#") : s+","+"#";
                    continue;
                }
                s = s.equals("") ?  (s+node.val) : s+","+node.val;
                if(node.left != null){
                    newfrontier.add(node.left);
                }else{
                    empty++;
                    newfrontier.add(new TreeNode(-1));
                }

                if(node.right != null){
                    newfrontier.add(node.right);
                }else{
                    empty++;
                    newfrontier.add(new TreeNode(-1));
                }
            }
            if(newfrontier.size() == empty){
                break;
            }
            frontier = newfrontier;
        }
        return s;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if(data==null||data.equals("")){
            return null;
        }
        // write your code here
        String[] arr = data.split(",");
        List<TreeNode> frontier = new ArrayList<>();
        TreeNode node1 = new TreeNode(new Integer(arr[0]));
        int i = 1;
        frontier.add(node1);
        while(frontier.size()>0){
            List<TreeNode> newfrontier = new ArrayList<>();
            for(TreeNode node:frontier){
                if(i>=arr.length){
                    break;
                }
                String left = arr[i++];
                if(left.equals("#")){
                    node.left = null;
                }else{
                    TreeNode nodel = new TreeNode(new Integer(left));
                    newfrontier.add(nodel);
                    node.left = nodel;
                }
                String right = arr[i++];
                if(right.equals("#")){
                    node.right = null;
                }else{
                    TreeNode noder = new TreeNode(new Integer(right));
                    newfrontier.add(noder);
                    node.right = noder;
                }
            }
            frontier = newfrontier;
        }


        return node1;

    }
}
