public class Main {

    public static void main(String[] args) {

        char[] str ;
        String s = new String("abcdefg".toCharArray());
        s = s.substring(s.length()-3) + s.substring(0,s.length()-3);
        str = s.toCharArray();
    }


}
