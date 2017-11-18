package math;

/**
 * Created by zhizha on 8/19/17.
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Notice

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 Have you met this question in a real interview? Yes
 Example
 Given num1 = "123", num2 = "45"
 return "168"
 */
public class BigIntegerAddition655 {

    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        if(num1==null || num1.trim().length() == 0){
            return num2;
        }else if(num2==null || num2.trim().length()==0){
            return num1;
        }else{
            int lenA = num1.length();
            int lenB = num2.length();
            int pointer = 0;
            if(lenA > lenB){
                int shift = lenA-lenB;
                for(int i = 0; i < shift; i++){
                    num2 = "0"+num2;
                }
                pointer = lenA-1;
            }else{
                int shift = lenB-lenA;
                for(int i = 0; i < shift; i++){
                    num1 = "0"+num1;
                }
                pointer = lenB-1;
            }
            int carryover = 0;
            String res = "";
            while(pointer >= 0){
                int ai = num1.charAt(pointer) - '0';
                int bi = num2.charAt(pointer) - '0';
                if((ai+bi+carryover)>=10){
                    carryover = (ai+bi+carryover)%10;
                    res = ((ai+bi+carryover)-10) +res;
                }
                pointer --;
            }
            return carryover==0?res:carryover+res;
        }
    }
}
