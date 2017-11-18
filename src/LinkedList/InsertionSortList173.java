package LinkedList;

/**
 * Created by zhizha on 8/20/17.
 */
public class InsertionSortList173 {

    /**
     * Sort a linked list using insertion sort.
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head==null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(cur!=null){
            ListNode pre = dummy;
            while(pre.next!=null && pre.next.val < cur.val){
                pre = pre.next;
            }
            ListNode tmp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tmp;
        }

        return dummy.next;
    }
}
