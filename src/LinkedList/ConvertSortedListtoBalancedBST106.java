package LinkedList;

/**
 * Created by zhizha on 11/11/17.
 */
public class ConvertSortedListtoBalancedBST106 {

    public static  void main(String[] arg){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2= new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ConvertSortedListtoBalancedBST106 convertSortedListtoBalancedBST106 = new ConvertSortedListtoBalancedBST106();
        convertSortedListtoBalancedBST106.sortedListToBST(listNode1);

    }

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        return buildTree(head);
    }

    private TreeNode buildTree(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head != null && head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dump1 = new ListNode(-1);
        ListNode dumphead = dump1;
        dump1.next = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            dump1 = dump1.next;
            p2 = p2.next.next;
        }
        ListNode median = dump1.next;
        ListNode right = median.next;
        median.next = null;
        dump1.next = null;
        TreeNode root = new TreeNode(median.val);
        if(dump1 != dumphead) {
            root.left = buildTree(head);
        }
        root.right = buildTree(right);
        return root;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
