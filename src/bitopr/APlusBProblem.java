package bitopr;

/**
 * Created by zhizha on 8/19/17.
 */
public class APlusBProblem {

    public static void main(String[] arg){
        APlusBProblem aPlusBProblem = new APlusBProblem();
        aPlusBProblem.aplusb(1,3);
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int carryover = (a&b)<<1;
        int sum0 = a^b;
        while(carryover != 0){
            a = sum0;
            b = carryover;
            sum0 = a^b;
            carryover = (a&b)<<1;
        }
        return sum0;
    }
}
