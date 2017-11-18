package segmenttree;

/**
 * Created by zhizha on 11/9/17.
 */
public class IntervalSumII207 {

    /* you may need to use some attributes here */
    SegmentTreeNode root = null;
    /*
    * @param A: An integer array
    */
    public IntervalSumII207(int[] A) {
        // do intialization if necessary
        root = buildTreeNode(A, 0, A.length-1);
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
    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        if(start > root.end || end < root.start){
            return 0;
        }else if(end>root.end){
            end = root.end;
        }else if(start<root.start){
            start = root.start;
        }
        return search(root, start, end);
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

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        if(index > root.end || index < root.start){
            return;
        }
        modifyTree(root, index, value);
    }

    private void modifyTree(SegmentTreeNode root, int index, int value){
        if(root.start == index && root.end == index){
             root.sum = value;
        }else{
            int leftEnd = (root.end+root.start)/2;
            int rightStart = leftEnd+1;
            if(index>=rightStart){
                 modifyTree(root.right, index, value);
                 root.sum = root.right.sum + root.left.sum;
            }else{
                modifyTree(root.left, index, value);
                root.sum = root.right.sum + root.left.sum;
            }
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
}
