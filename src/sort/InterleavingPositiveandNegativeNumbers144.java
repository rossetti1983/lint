package sort;

/**
 * Created by zhizha on 11/15/17.
 */
public class InterleavingPositiveandNegativeNumbers144 {

    public static void main(String[] arg){
        InterleavingPositiveandNegativeNumbers144 interleavingPositiveandNegativeNumbers144 = new InterleavingPositiveandNegativeNumbers144();
        interleavingPositiveandNegativeNumbers144.rerange(new int[]{28,2,-22,-27,2,9,-33,-4,-18,26,25,34,-35,-17,2,-2,32,35,-8});
    }

    /*
    * @param A: An integer array.
    * @return: nothing
    */
    public void rerange(int[] A) {
        // write your code here
        int cp = 0;
        int cn = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i]>0){
                cp++;
            }else{
                cn++;
            }
        }
        int re0 = 0;
        int re1 = 1;
        if (cp > cn) {
            re0 = 0;
            re1 = 1;
        }else{
            re0 = 1;
            re1 = 0;
        }

        int pointer = 0;
        int index = 0;
        while(index < A.length){
            if(pointer%2 == re0){
                if(A[pointer] > 0) {
                    pointer++;
                    if(pointer>=index){
                        index = pointer+1;
                    }
                }else{
                    if(A[index] > 0){
                        swap(A, pointer, index);
                        pointer++;
                    }
                    index++;
                }
            }else if(pointer%2 == re1){
                if(A[pointer] < 0) {
                    pointer++;
                    if(pointer>=index){
                        index = pointer+1;
                    }
                }else{
                    if(A[index] < 0){
                        swap(A, pointer, index);
                        pointer++;
                    }
                    index++;
                }
            }

        }
    }

    private void swap(int[] a, int index, int pointer) {
        int tmp = a[index];
        a[index] = a[pointer];
        a[pointer] = tmp;

        //return ((Double)(Math.pow(2, -1)*1%Integer.MAX_VALUE)).intValue();
    }
}
