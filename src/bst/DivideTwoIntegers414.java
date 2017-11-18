package bst;

import java.util.Arrays;

/**
 * Created by zhizha on 8/31/17.
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return 2147483647

 Have you met this question in a real interview? Yes
 Example
 Given dividend = 100 and divisor = 9, return 11.
 */
public class DivideTwoIntegers414 {

    public static void main(String[] arg){
        DivideTwoIntegers414 divideTwoIntegers414 = new DivideTwoIntegers414();
        divideTwoIntegers414.divide(-2147483648,-1);
    }
    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        boolean negRes = false;
        if((dividend < 0 && divisor >0) || dividend >0 && divisor < 0){
            negRes = true;
        }
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend < divisor){
            return 0;
        }

        int res = divideHelper(dividend, divisor,divisor, divisor, 1,1);
        if(negRes){
            return 0-res;
        }
        return res;
    }

    public int divideHelper(int dividend, int divisor, int lastDivisor, int originalDivisor, int res, int preRes){
        if(dividend == divisor){
            return res;
        }
        if(dividend < divisor && res == 1){
            return 0;
        }
        if(dividend < divisor){
            dividend = dividend - lastDivisor;
            return preRes + divideHelper(dividend, originalDivisor, originalDivisor, originalDivisor, 1,1);
        }else{
            return divideHelper(dividend, divisor + divisor, divisor, originalDivisor, res+res, res);
        }
    }
}
