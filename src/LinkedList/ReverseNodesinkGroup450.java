package LinkedList;

/**
 * Created by zhizha on 11/12/17.
 */
public class ReverseNodesinkGroup450 {

    public static void main(String[] arg){
        ReverseNodesinkGroup450 reverseNodesinkGroup450 = new ReverseNodesinkGroup450();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseNodesinkGroup450.reverseKGroup(listNode1,2);
    }

    /*
    * @param head: a ListNode
    * @param k: An integer
    * @return: a ListNode
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if(head == null || k<2){
            return head;
        }

        int len = 1;
        ListNode lenHead = head;
        while(lenHead.next!=null){
            lenHead = lenHead.next;
            len++;
        }

        if(k>len){
            return head;
        }

        int loop = len/k;
        ListNode dummy = new ListNode(-1);
        ListNode nHead = head;
        ListNode preNode = dummy;
        ListNode newPre = null;
        for(int i =0 ; i < loop; i++){
            for(int j = 0; j<k; j++){
               ListNode tmp = preNode.next;
               preNode.next = nHead;
               nHead = nHead.next;
               preNode.next.next = tmp;
                if(j==0){
                    newPre = preNode.next;
                }
            }
            preNode = newPre;
        }
        if(nHead != null){
            preNode.next = nHead;
        }

        return dummy.next;
    }
}
