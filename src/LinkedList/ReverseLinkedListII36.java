package LinkedList;

/**
 * Created by zhizha on 10/16/17.
 */
public class ReverseLinkedListII36 {

    /*
    * @param head: ListNode head is the head of the linked list
    * @param m: An integer
    * @param n: An integer
    * @return: The head of the reversed ListNode
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode reverseHead = null;
        ListNode dummyTail = null;
        int i = 1;
        if(m==1){
            reverseHead = dummy;
        }
        while(head != null){
            if(i < m){
                reverseHead = head;
                head = head.next;
            }else if(i >=m && i <= n){
                if (i == m) {
                    dummyTail = head;
                }
                ListNode pre = reverseHead.next;
                reverseHead.next = head;
                head = head.next;
                reverseHead.next.next = pre;
            }else{
                dummyTail.next = head;
                break;
            }
            i++;
        }
        return (m>1)?dummy.next:reverseHead.next;
    }
}
