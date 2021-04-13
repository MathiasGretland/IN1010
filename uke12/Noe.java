package uke12;

public class Noe {
    public static void main(String[] args) {
        /*
        int[] oldArray = {1,2,3,4,5,6,7,8,9};
        int[][] newArray = new int[3][3];

        int row = 0;
        int col = 0;
        for (int value: oldArray){
            newArray[row][col] = value;
            row++;
            if ((row % 3) == 0){
                col++;
                row = 0;
            }
        }
        System.out.println(newArray[0][2]);

         */

        /*
        int[] arr = {1,2,3,4,5,6,7};

        for (int i : arr){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
         */
        //System.out.println(mystery(6));
        //System.out.println(scramble("compiler", 3));

        //whatsItDo("WATCH");
        System.out.println(recombine("pear", "apple"));
    }

    private static String recombine(String word1, String word2){
        String firstHalf = "";
        for (int i = 0; i < word1.length() / 2; i++){
            firstHalf += word1.charAt(i);
        }
        String secondHalf = "";
        for (int i = word2.length() / 2; i < word2.length(); i++){
            secondHalf += word2.charAt(i);
        }

        return firstHalf + secondHalf;
    }

    /*
    public static void whatsItDo(String str){
        int len = str.length();
        if (len > 1){
            String temp =  str.substring(0, len-1);
            whatsItDo(temp);
            System.out.println(temp);
        }
    }

     */

    /*
    public static int mystery(int n){
        int x = 1;
        int y = 1;

        while (n > 2){
            x = x + y;

            y = x - y;
            n--;
        }

        return x;

    }
     */

    /*
    public static String scramble(String word, int howFar){
        return word.substring(howFar + 1, word.length()) +
                word.substring(0, howFar);
    }

     */
}
