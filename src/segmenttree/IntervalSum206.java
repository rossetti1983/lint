package segmenttree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/8/17.
 */
public class IntervalSum206 {

    private class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public class SegmentTreeNode {
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        List<Long> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        SegmentTreeNode tree = buildTreeNode(A, 0, A.length-1);

        for(Interval interval : queries){
            res.add(search(tree, interval.start, interval.end));
        }
        return res;
    }

    private SegmentTreeNode buildTreeNode(int[] a, int start, int end) {
        if(start == end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            root.sum = a[start];
            return root;
        }else{
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            int leftEnd = (end+start)/2;
            int rightStart = leftEnd+1;
            root.left = buildTreeNode(a, start, leftEnd);
            root.right = buildTreeNode(a, rightStart, end);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }
    }

    private long search(SegmentTreeNode root, int start, int end){
        if(root.start == start && root.end == end){
            return root.sum;
        }else{
            int leftEnd = (root.end+root.start)/2;
            int rightStart = leftEnd+1;
            if(start>=rightStart){
                return search(root.right, start, end);
            }else if(end<=leftEnd){
                return search(root.left, start, end);
            }else{
                return search(root.left, start, leftEnd) + search(root.right, rightStart, end);
            }
        }
    }
}
