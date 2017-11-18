package segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/12/17.
 */
public class CountofSmallerNumberbeforeitself249 {

    public static void main(String[] arg){
        CountofSmallerNumberbeforeitself249 countofSmallerNumberbeforeitself249 = new CountofSmallerNumberbeforeitself249();
        countofSmallerNumberbeforeitself249.countOfSmallerNumberII(new int[]{1,2,7,8,5});
    }
    /*
    * @param A: an integer array
    * @return: A list of integers includes the index of the first number and the index of the last number
    */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        SegmentTreeNode root = buildTree(0,10000);
        List<Integer> res = new ArrayList<>();
        for(int a:A){
            updateTree(a, root);
            res.add(queryTree(a, root));
        }

        return res;
    }

    private Integer queryTree(int a, SegmentTreeNode root) {
        if(root.start < a && root.end < a){
            return root.count;
        }else if(root.start < a && root.end >= a){
            int leftEnd = (root.start + root.end)/2;
            int rightStart = leftEnd+1;
            int count = 0 ;
            if(a>=rightStart){
                count += queryTree(a, root.right);
                count += queryTree(a, root.left);
            }else{
                count += queryTree(a, root.left);
            }
            return count;
        }else{
            return 0;
        }
    }

    private void updateTree(int a, SegmentTreeNode root) {
        if(a == root.start && root.start == root.end){
            root.count++;
            return;
        }
        int leftEnd = (root.start+root.end)/2;
        int rightStart = leftEnd+1;
        if(a>=rightStart){
            updateTree(a, root.right);
        }else{
            updateTree(a, root.left);
        }
        root.count = root.left.count+root.right.count;
    }

    private SegmentTreeNode buildTree(int start, int end) {
        if(start == end){
            return new SegmentTreeNode(start,end, 0);
        }
        int leftEnd = (start+end)/2;
        int rightStart = leftEnd+1;
        SegmentTreeNode root = new SegmentTreeNode(start,end, 0);
        root.left = buildTree(start, leftEnd);
        root.right = buildTree(rightStart, end);
        return root;
    }

    private class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
