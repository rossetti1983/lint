package math;

/**
 * Created by zhizha on 11/13/17.
 */
public class DigitCounts3 {

    public static void main(String[] arg){
        DigitCounts3 digitCounts3 = new DigitCounts3();
        digitCounts3.digitCounts(2, 220);
    }
    /*
    * @param : An integer
    * @param : An integer
    * @return: An integer denote the count of digit k in 1..n
    */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0 ;
        for(int i = 0 ; i <=n; i++){
            if(i==200){
                System.out.println("");
            }
            count += checkKs(i,k);
        }
        return count;
    }

    private int checkKs(int n, int k){
        int kcount = 0;
        Double len = Math.floor(Math.log10(n));
        for(int i = len.intValue(); i >= 0; i--){
            Double div = k * Math.pow(10,i);
            /*if(div == n){
                kcount++;
                break;
            }*/
            int rem = n-div.intValue();
            if(Math.floor(Math.log10(rem)) <= i-1 || rem == 0){
                kcount++;
                n = rem;
                i = ((Double)Math.floor(Math.log10(n))).intValue()+1;
                continue;
            }
            int highest = n/((Double)Math.pow(10,i)).intValue();
            n = n - highest*((Double)Math.pow(10,i)).intValue();

        }
      return kcount;
    }
}
