package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 8/12/17.
 */
public class MergekSortedLists104 {

    public static void main(String[] arg){
        String s = "-10->-9->-9->-3->-1->-1->0,-5,4,-8,-9->-6->-5->-4->-2->2->3,-3->-3->-2->-1->0";
        String[] ss = s.split(",");
        List<ListNode> listNodes = new ArrayList<>();
        ListNode head = null;
        for(String sss : ss){
            String[] ssss = sss.split("->");
            for(int i = ssss.length -1 ; i>=0; i--){
            Integer val = Integer.valueOf(ssss[i]);
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
            }
            listNodes.add(head);
            head =null;
        }


        MergekSortedLists104 mergekSortedLists104 = new MergekSortedLists104();
        mergekSortedLists104.mergeKLists(listNodes);
    }

    /**
     * -10->-9->-9->-3->-1->-1->0->null,
     * -5->null,
     * 4->null,
     * -8->null,
     * null,
     * -9->-6->-5->-4->-2->2->3->null,
     * -3->-3->-2->-1->0->null
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }else if(lists.size() == 1){
            return lists.get(0);
        }

        int len  = 0;
        for(ListNode listNode : lists){
            while(listNode != null){
                len ++;
                listNode = listNode.next;
            }
        }

        ListNode[] listNodes = buildHeap(lists, len);
        ListNode sortedListNode = buildSortedList(listNodes);
        return sortedListNode;
    }

    private ListNode buildSortedList(ListNode[] listNodes) {
        ListNode head = null;
        int len = listNodes.length;
        while(len > 0){
            listNodes[0].next = head;
            head = listNodes[0];
            listNodes[0] = listNodes[len - 1];
            heapify(listNodes, --len);
        }
        return head;
    }

    private void heapify(ListNode[] listNodes, int len) {
        int index = 0;
        if(len>1) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            while (rightChild <= len - 1 && (listNodes[index].val < listNodes[leftChild].val ||
                    listNodes[index].val < listNodes[rightChild].val)) {
                int targetIndex = -1;
                if(listNodes[leftChild].val > listNodes[rightChild].val){
                    targetIndex = leftChild;
                }else{
                    targetIndex = rightChild;
                }
                ListNode tmp = listNodes[targetIndex];
                listNodes[targetIndex] = listNodes[index];
                listNodes[index] = tmp;
                index = targetIndex;
                leftChild = index * 2 + 1;
                rightChild = index * 2 + 2;
            }
            if( leftChild == len - 1 && listNodes[index].val < listNodes[leftChild].val ){
                ListNode tmp = listNodes[leftChild];
                listNodes[leftChild] = listNodes[index];
                listNodes[index] = tmp;
            }
        }
    }

    private ListNode[] buildHeap(List<ListNode> lists, int capacity) {
        ListNode[] listNodes = new ListNode[capacity];
        int len = 0;
        for(ListNode listNode : lists){
            while(listNode != null){
                int index = len++;
                listNodes[index] = new ListNode(listNode.val);
                if(len > 1){
                    int parentIndex = (index - 1)/2;
                    while(listNodes[parentIndex].val < listNodes[index].val && parentIndex >= 0){
                         ListNode tmp = listNodes[parentIndex];
                         listNodes[parentIndex] = listNodes[index];
                         listNodes[index] = tmp;
                         index = parentIndex;
                         parentIndex = (index - 1)/2;
                    }
                }
                listNode = listNode.next;
            }
        }
        return listNodes;
    }


}


  //Definition for ListNode.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
