package uke6;

public class Parkeringshus {
    static Parkeringsplass[] etasje1 = new Parkeringsplass[10];
    static Parkeringsplass[] etasje2 = new Parkeringsplass[10];

    public static void main(String[] args) {
        Bil mercedes = new Bil("12314",5);
        Bil hummer = new Bil("123124", 5);
        Bil mustang = new Bil("12312412", 7);

        Motorsykkel harley = new Motorsykkel("3121", 100);
        Motorsykkel yamaha = new Motorsykkel("e131231", 20);
        Motorsykkel barneSykkel = new Motorsykkel("312312", 120);

        etasje1[4] = new Parkeringsplass();
        etasje1[4].parker(mercedes);

        etasje1[7] = new Parkeringsplass();
        etasje1[7].parker(hummer);

        etasje1[2] = new Parkeringsplass();
        etasje1[2].parker(mustang);

        etasje2[3] = new Parkeringsplass();
        etasje2[3].parker(harley);

        etasje2[4] = new Parkeringsplass();
        etasje2[4].parker(yamaha);

        etasje2[8] = new Parkeringsplass();
        etasje2[8].parker(barneSykkel);

        for (int i = 0; i < 10; i++){
            if (etasje1[i] != null) {
                etasje1[i].hent();
                etasje1[i] = null;
            }
            if (etasje2[i] != null) {
                etasje2[i].hent();
                etasje2[i] = null;
            }
        }

    }
}
