package array;

/**
 * Created on 8/7/17.
 */
public class MergeTwoSortedArrays6 {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     * Merge two given sorted integer array A and B into a new sorted integer array.
     */
    public int[] mergeSortedArray(int[] A, int[] B) {

        if(A == null || A.length == 0){
            return B;
        }else if(B == null || B.length == 0){
            return A;
        }else {
            int lenA = A.length;
            int lenB = B.length;
            int[] newArray = new int[lenA + lenB];
            int indexA = 0;
            int indexB = 0;
            for (int i = 0; i < lenA + lenB; i++){
                if(indexA < lenA && indexB < lenB) {
                    if (A[indexA] < B[indexB]) {
                        newArray[i] = A[indexA++];
                    } else {
                        newArray[i] = B[indexB++];
                    }
                }else if (lenA == indexA){
                    newArray[i] = B[indexB++];
                }else{
                    newArray[i] = A[indexA++];
                }
            }
            return  newArray;
        }

    }
}
