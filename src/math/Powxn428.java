package math;

/**
 * Created by zhizha on 11/13/17.
 */
public class Powxn428 {

    public static void main(String[] arg){
        Powxn428 powxn428 = new Powxn428();
        powxn428.myPow(8.88023,-6);
    }

    /*
    * @param x: the base number
    * @param n: the power number
    * @return: the result
    */
    public double myPow(double x, int n) {
        // write your code here
        if(x == 0.0 || n == 0){
            return 0.0;
        }
        return pow(x,n);

    }

    public double pow(double x, int n){
        if(n==1){
            return x;
        }
        if(n==2){
            return x*x;
        }
        if(n==-1){
            return 1/x;
        }
        if(n==-2){
            return 1/(x*x);
        }
         int i = n/2;
         int re = n%2;

         if(re==0) {
             return pow(x, i) * pow(x, i);
         }else{
             return pow(x, i) * pow(x, i) * pow(x, re);
         }
    }
}
