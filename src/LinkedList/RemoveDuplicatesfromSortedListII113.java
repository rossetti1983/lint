package LinkedList;

import java.util.HashMap;

/**
 * Created by zhizha on 10/16/17.
 */
public class RemoveDuplicatesfromSortedListII113 {


    /*
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        ListNode newHead = head;
        while(newHead != null){
            if(cache.containsKey(newHead.val)){
                cache.put(newHead.val,cache.get(newHead.val)+1);
            }else{
                cache.put(newHead.val,1);
            }
            newHead = newHead.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(head != null){
            if(cache.get(head.val) == 1){
                pre.next = head;
                pre = pre.next;
            }
            head = head.next;
        }

        return dummy.next;
    }


}
