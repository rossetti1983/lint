package bitopr;

/**
 * Created by zhizha on 8/19/17.
 */
public class AddBinary408 {

    /*
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        if(a==null || a.trim().length() == 0){
            return b;
        }else if(b==null || b.trim().length()==0){
            return a;
        }else{
            int lenA = a.length();
            int lenB = b.length();
            int pointer = 0;
            if(lenA > lenB){
                int shift = lenA-lenB;
                for(int i = 0; i < shift; i++){
                    b = "0"+b;
                }
                pointer = lenA-1;
            }else{
                int shift = lenB-lenA;
                for(int i = 0; i < shift; i++){
                    a = "0"+a;
                }
                pointer = lenB-1;
            }
            int carryover = 0;
            String res = "";
            while(pointer >= 0){
                int ai = a.charAt(pointer) - '0';
                int bi = b.charAt(pointer) - '0';
                if((ai+bi+carryover)>=2){
                    int newcarryover = (ai+bi+carryover)/2;
                    res = ((ai+bi+carryover)%2) +res;
                    carryover= newcarryover;
                }else{
                    res = ((ai+bi+carryover)%2) +res;
                }
                pointer --;
            }
            return carryover==0?res:1+res;
        }
    }
}
