package etterEksamen;

public class SumOfTwoNumbers {
    public int sum(int a, int b){
        return (a+b);
    }

    public int tilSekunder(int timer){
        return ((timer*60)*60);
    }


    public int tredje(int a, int b){
        if (!(a+b <= 0)){
            return ((a+b)-1);
        }
        else {
            return 0;
        }
    }

    public static int countTrue(boolean[] array){
        int teller = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == true){
                teller++;
            }
        }
        return teller;
    }

    public static int triArea(int a, int b){
        return ((a * b) /2);
    }

    public static int remainder(int a, int b){
        return (a%b);
    }

    public static int addition(int a){
        return (a+1);
    }

    public static String nameShuffle(String a){
        String[] data = a.split(" ");
        String nyttNavn = "";
        for (int i = data.length-1; i >= 0; i--){
            nyttNavn += data[i] + " ";
        }
        return nyttNavn;
    }

    public static int differenceMaxMin(int[] array){
        int storst = array[0];
        int minst = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < minst){
                minst = array[i];
            }
            if (array[i] > storst){
                storst = array[i];
            }
        }
        return storst - minst;

    }

    public static void main(String[] args) {
        System.out.println(nameShuffle("1 2 3 4"));
        int[] array = new int[]{10,4,1,2,8,91};
        System.out.println(differenceMaxMin(array));
    }


}














































