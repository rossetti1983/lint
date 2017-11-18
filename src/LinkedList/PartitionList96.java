package LinkedList;

import array.P132attern636;

/**
 * Created by zhizha on 8/22/17.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Have you met this question in a real interview? Yes
 Example
 Given 1->4->3->2->5->2->null and x = 3,
 return 1->2->2->4->3->5->null.
 */
public class PartitionList96 {

    public static void main(String[] arg) {
        PartitionList96 partitionList96 = new PartitionList96();
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        partitionList96.partition(listNode, 2);
    }

    /*
    * @param head: The first node of linked list
    * @param x: An integer
    * @return: A ListNode
    */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummyLx = new ListNode(-1);
        ListNode dummyGx = new ListNode(-1);
        ListNode l = dummyLx;
        ListNode g = dummyGx;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                g.next = head;
                g = g.next;
            }
            head = head.next;
        }
        l.next = dummyGx.next;
        return dummyLx.next;

    }

}
