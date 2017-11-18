package sort;

/**
 * Created by zhizha on 11/15/17.
 */
public class SortColorsII143 {

    public static void main(String[] arg){
        SortColorsII143 sortColorsII143 = new SortColorsII143();
        sortColorsII143.sortColors2(new int[]{2,1,1,2,2},2);
    }

    /*
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int i = 0 ;
        while(i<colors.length){
            if(colors[i]>0){
                if(colors[colors[i]-1] < 0){
                    colors[colors[i]-1]--;
                    colors[i] = 0;
                    i++;
                }else if(colors[colors[i]-1] == 0){
                    colors[colors[i]-1] = -1;
                    colors[i] = 0;
                    i++;
                }else{
                    int tmp = colors[colors[i]-1];
                    if(i==colors[i]-1){
                        colors[colors[i]-1] = -1;
                    }else {
                        colors[colors[i] - 1] = -1;
                        colors[i] = tmp;
                    }

                }
            }else{
                i++;
            }
        }

        int in =  colors.length - 1;
        for(int j = colors.length ; j >= 1; j--){
            int num = Math.abs(colors[j-1]);
            int kk = 0;
            while(kk<num){
                colors[in--] = j;
                kk++;
            }
            if(in < 0){
                return;
            }
        }
    }
}
