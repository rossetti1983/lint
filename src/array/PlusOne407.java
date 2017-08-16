package array;

/**
 * Created by zhizha on 8/11/17.
 */
public class PlusOne407 {

    /**
     * @param digits a number represented as an array of digits
     * @return the result
     * <p>
     * Given a non-negative number represented as an array of digits, plus one to the number.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list.
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * Given [1,2,3] which represents 123, return [1,2,4].
     * <p>
     * Given [9,9,9] which represents 999, return [1,0,0,0].
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carryover = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int a = digits[i] + 1;
                if (a == 10) {
                    digits[i] = 0;
                    carryover = 1;
                } else {
                    digits[i] = a;
                }
            } else {
                int a = digits[i] + carryover;
                if (a == 10) {
                    digits[i] = 0;
                    carryover = 1;
                } else {
                    digits[i] = a;
                    carryover = 0;
                }
            }
        }
        if (carryover == 1) {
            int[] newDigits = new int[digits.length + 1];
            for (int i = 0; i < newDigits.length; i++) {
                if (i == 0) {
                    newDigits[i] = carryover;
                } else {
                    newDigits[i] = digits[i - 1];
                }
            }
            return newDigits;
        }

        return digits;
    }

}
