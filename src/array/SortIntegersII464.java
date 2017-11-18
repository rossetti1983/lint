package array;

/**
 * Created by zhizha on 8/27/17.
 */
public class SortIntegersII464 {

    public static void main(String[] arg){
        SortIntegersII464 sortIntegersII464 = new SortIntegersII464();
        sortIntegersII464.sortIntegers2(new int[]{3,2,1,4,5});
    }

    /**
     * @param A an integer array
     * @return void
     */
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if(A == null || A.length < 2){
            return;
        }
        int lastIndex = A.length - 1;
        mergeSort(A, 0, lastIndex);
    }
    public void mergeSort(int[] A, int start, int end){
        if(start == end){
            return;
        }else if((end - start) == 1){
            if(A[end] < A[start]){
                int tmp = A[end];
                A[end] = A[start];
                A[start] = tmp;
            }else{
                return;
            }
        }else{
            int len = end - start + 1;
            int mid = start + (end - start) /2;
            mergeSort(A, start, mid);
            mergeSort(A, mid+1, end);
            int[] B = new int[len];
            int index = 0;
            int left = start;
            int right = mid+1;
            while(index < len){
                if(left <= mid && right <= end && A[left] >= A[right]){
                    B[index++] = A[right++];
                }else if(left <= mid && right <= end && A[left] < A[right]){
                    B[index++] = A[left++];
                }else{
                    if(left>mid){
                        B[index++] = A[right++];
                    }else{
                        B[index++] = A[left++];
                    }
                }
            }

            for(int i=0; i< len; i++){
                A[start+i] = B[i];
            }

        }
    }
}
