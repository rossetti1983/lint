package segmenttree;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/8/17.
 */
public class IntervalMinimumNumber205 {
    /*
    * @param A: An integer array
    * @param queries: An query list
    * @return: The result list
    */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        List<Integer> re = new ArrayList<>();
        if(A == null || A.length == 0 || queries == null || queries.size() == 0){
            return re;
        }


        SegmentTreeNode  root = buildTreeNode(A, 0, A.length-1);


        for(Interval interval : queries){
            int start = interval.start;
            int end = interval.end;
            re.add(queryMin(root, start,end));
        }
    return re;
    }

    private int queryMin(SegmentTreeNode root, int start, int end){
        if(start == root.start && end == root.end){
            return root.min;
        }else{
            int leftEnd = (root.end+root.start)/2;
            int rightStart = leftEnd+1;
            if(start>=rightStart){
                return queryMin(root.right, start, end);
            }else if(end <= leftEnd){
                return queryMin(root.left, start, end);
            }else{
                return Math.min(queryMin(root.left, start, leftEnd), queryMin(root.right, rightStart, end));
            }
        }
    }

    private SegmentTreeNode buildTreeNode(int[] a, int start, int end) {
        if(start == end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end, a[start]);
            return root;
        }else{
            int leftEnd = (end+start)/2;
            int rightStart = leftEnd+1;
            SegmentTreeNode sleft = buildTreeNode(a, start, leftEnd);
            SegmentTreeNode sright = buildTreeNode(a, rightStart, end);

            int min = Math.min(sleft.min, sright.min);
            SegmentTreeNode root = new SegmentTreeNode(start, end, min);
            root.left = sleft;
            root.right = sright;
            return root;
        }
    }


    private class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public class SegmentTreeNode {
      public int start, end, min;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end, int min) {
          this.start = start;
          this.end = end;
          this.min = min;
          this.left = this.right = null;
      }
  }
}
