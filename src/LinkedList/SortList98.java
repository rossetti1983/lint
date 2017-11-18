package LinkedList;

/**
 * Created by zhizha on 11/11/17.
 */
public class SortList98 {

    public static  void main(String[] arg){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode3;
        listNode3.next = listNode2;
        SortList98 sortList98 = new SortList98();
        sortList98.sortList(listNode1);
    }
    /*
    * @param head: The head of linked list.
    * @return: You should return the head of the sorted linked list, using constant space complexity.
    */
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head != null && head.next == null){
            return head;
        }else {
            ListNode d1head = head;
            ListNode d2head = head;
            while (d2head.next != null && d2head.next.next != null) {
                d1head = d1head.next;
                d2head = d2head.next.next;
            }

            ListNode median = d1head;
            ListNode right = d1head.next;
            median.next = null;
            ListNode sortedLeft = mergeSort(head);
            ListNode sortedRight = mergeSort(right);
            ListNode newDummyHead = new ListNode(-1);
            ListNode newhead = newDummyHead;
            while(sortedLeft != null && sortedRight != null){
                if(sortedLeft.val>sortedRight.val){
                    ListNode tmp = newhead.next;
                    newhead.next = sortedRight;
                    sortedRight = sortedRight.next;
                    newhead = newhead.next;
                    newhead.next = tmp;
                }else{
                    ListNode tmp = newhead.next;
                    newhead.next = sortedLeft;
                    sortedLeft = sortedLeft.next;
                    newhead = newhead.next;
                    newhead.next = tmp;
                }
            }
            while(sortedLeft != null){
                ListNode tmp = newhead.next;
                newhead.next = sortedLeft;
                sortedLeft = sortedLeft.next;
                newhead = newhead.next;
                newhead.next = tmp;
            }
            while(sortedRight != null){
                ListNode tmp = newhead.next;
                newhead.next = sortedRight;
                sortedRight = sortedRight.next;
                newhead = newhead.next;
                newhead.next = tmp;
            }
            return newDummyHead.next;
        }

    }
}
