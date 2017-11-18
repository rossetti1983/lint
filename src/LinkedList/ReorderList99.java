package LinkedList;

/**
 * Created by zhizha on 8/16/17.
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln

 reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

 Have you met this question in a real interview? Yes
 Example
 Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 */
public class ReorderList99 {

    public static void main(String[] arg){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ReorderList99 reorderList99 = new ReorderList99();
        reorderList99.reorderList(a);
    }

    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null){
            return;
        }
        ListNode node = head;
        ListNode node0 = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        int mid = len/2 + 1;

        int i = 1 ;
        while(i < mid){
            node0 = node0.next;
            i++;
        }
        ListNode lastNode = node0;
        ListNode reverseNode = node0.next;
        lastNode.next = null;
        while(reverseNode != null){
            ListNode nextReverse = reverseNode.next;
            reverseNode.next = lastNode;
            lastNode = reverseNode;
            reverseNode = nextReverse;
        }
        ListNode node1 = head;
        while(node1.next != null && lastNode.next !=null){
            ListNode next = node1.next;
            ListNode nextLastNode = lastNode.next;
            node1.next = lastNode;
            lastNode.next = next;
            lastNode = nextLastNode;
            node1 = next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
