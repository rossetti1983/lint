package math;

/**
 * Created by zhizha on 8/27/17.
 */
public class SqrtX141 {

    public static void main(String[] arg){
        SqrtX141 sqrtX141 = new SqrtX141();
        sqrtX141.sqrt(255);
    }

    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x==0 || x == 1){
            return x;
        }
        return sqrt(x, 1, x);
    }

    int lastCan = -1;
    public int sqrt(int x, int start, int end){
        if(start == end){
            if(Math.pow(start,2)>x){
                return start - 1;
            }
        }
        int mid = start + (end - start)/2;
        if(Math.pow(mid, 2) == x){
            return mid;
        }else if(Math.pow(mid, 2) < x){
            lastCan = mid;
            return sqrt(x, mid + 1, end);
        }else{
            lastCan = mid;
            return sqrt(x, start, mid - 1);
        }
    }
}
