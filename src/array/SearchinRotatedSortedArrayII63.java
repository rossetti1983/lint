package array;

/**
 * Created by zhizha on 10/21/17.
 */
public class SearchinRotatedSortedArrayII63 {

    public static void main(String[] arg){
        SearchinRotatedSortedArrayII63 searchinRotatedSortedArrayII63 = new SearchinRotatedSortedArrayII63();
        searchinRotatedSortedArrayII63.search(new int[]{3,4,5,5,6,1,1,2}, 2);
    }

    /*
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if(A==null || A.length == 0){
            return false;
        }
        int offset = 0;
        for(int i = 0 ; i < A.length-1; i++){
            if(A[i]>A[i+1]){
                offset = i+1;
                break;
            }
        }

        return bfs(A, target, 0, A.length-1, offset);
    }

    public boolean bfs(int[] A, int target, int start, int end, int offset){
        if(start > end){
            return false;
        }else{
            int mid = start + (end-start)/2;
            if(A[(mid+offset)%A.length]==target){
                return true;
            }else if(A[(mid+offset)%A.length] < target){
                return bfs(A, target, mid+1, end, offset);
            }
            else{
                return bfs(A, target, start, mid-1, offset);
            }
        }
    }
}
