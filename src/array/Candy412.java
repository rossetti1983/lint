package array;

/**
 * Created by zhizha on 10/24/17.
 */
public class Candy412 {

    public static void main(String[] arg){
        Candy412 candy412 = new Candy412();
        candy412.candy(new int[]{5,-2,7,6,7,5,1,-1,2});
    }

    /*
    * @param ratings: Children's ratings
    * @return: the minimum candies you must give
    */
    public int candy(int[] ratings) {
        // write your code here
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        if(ratings.length == 1){
            return 1;
        }

        int[] candy = new int[ratings.length];
        candy[0] = 1;

        for(int i = 1 ; i < ratings.length ; i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }else {
                candy[i] = 1;
                int j = i;
                while ((j - 1) >= 0 && ratings[j-1] > ratings[j] && candy[j-1]<=candy[j]) {
                      candy[j-1] ++;
                      j--;
                }
            }
        }

        int sum = 0;
        for(int i = 0 ; i < candy.length; i++){
            sum = sum + candy[i];
        }
        return sum;
    }
}
