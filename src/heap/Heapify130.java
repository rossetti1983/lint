package heap;

/**
 * Created by zhizha on 8/12/17.
 */
public class Heapify130 {


    /**
     *
     * Given an integer array, heapify it into a min-heap array.

     For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if(A == null || A.length < 2){
            return ;
        }else{

            for(int i = A.length/2 - 1; i >=0; i --){
                heapify(A, i, A.length);
            }
        }
    }

    private void heapify(int[] a, int index, int heapSize) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int minIndex  = Integer.MAX_VALUE;
            if(leftChild <= heapSize - 1 && a[leftChild] < a[index]){
                minIndex = leftChild;
            }
            if(rightChild <= heapSize -1 && a[rightChild] < a[index]){
                if(a[rightChild] < a[leftChild]){
                    minIndex = rightChild;
                }
            }

            if(minIndex <= heapSize - 1) {
                int tmp = a[minIndex];
                a[minIndex] = a[index];
                a[index] = tmp;
                index = minIndex;
                heapify(a, index, heapSize);
            }
    }
}
