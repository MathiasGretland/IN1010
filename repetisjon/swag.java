package repetisjon;

public class swag {
    public static void main(String[] args) {
        String[] swag = new String[10];
        swag[0] = "kekw";
        swag[1] = "kekw";
        swag[2] = "kekw";
        swag[3] = "kekw";


        int teller = 0;
        for (int i = 0; i < swag.length; i++){
            if (swag[i] != null){
                teller++;
            }
        }

        System.out.println(teller);



    }

}
