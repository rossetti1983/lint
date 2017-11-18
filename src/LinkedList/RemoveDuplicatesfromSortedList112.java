package LinkedList;

/**
 * Created by zhizha on 8/23/17.
 */
public class RemoveDuplicatesfromSortedList112 {

    public static void main(String[] arg) {
        RemoveDuplicatesfromSortedList112 RemoveDuplicatesfromSortedList112 = new RemoveDuplicatesfromSortedList112();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        deleteDuplicates(listNode);

    }
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        int pre = 0;
        int index = 0;
        ListNode node = dummy;
        while(head!=null){
            if(index++==0){
                pre = head.val;
            }else{
                if(head.val == pre){
                    head = head.next;
                    continue;
                }else{
                    pre = head.val;
                }
            }
            node.next = head;
            node = node.next;
            node.next = null;
            head = head.next;
        }
        return dummy.next;
    }
}
