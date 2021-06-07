package utfordringer;

public class Parkeringshus {
    Parkeringsplass [] etasje1 = new Parkeringsplass[10];
    Parkeringsplass [] etasje2 = new Parkeringsplass[10];

    public static void main(String[] args) {
        Parkeringshus swagHotel = new Parkeringshus();

        Bil mercedes = new Bil("KUSH420" ,5);
        Bil toyota = new Bil("SHAGWAGON", 5);
        Bil amg = new Bil("BENZTRUCK", 2);

        Motorsykkel harley = new Motorsykkel("LOL", 91);
        Motorsykkel suzuki = new Motorsykkel("gay", 213);
        Motorsykkel kawaiii = new Motorsykkel("XD", 1234);

        swagHotel.etasje1[4] = new Parkeringsplass();
        swagHotel.etasje1[4].parker(mercedes);

        swagHotel.etasje2[4] = new Parkeringsplass();
        swagHotel.etasje2[4].parker(toyota);

        swagHotel.etasje1[5] = new Parkeringsplass();
        swagHotel.etasje1[5].parker(amg);

        swagHotel.etasje2[8] = new Parkeringsplass();
        swagHotel.etasje2[8].parker(harley);

        swagHotel.etasje1[2] = new Parkeringsplass();
        swagHotel.etasje1[2].parker(suzuki);

        swagHotel.etasje2[5] = new Parkeringsplass();
        swagHotel.etasje2[5].parker(kawaiii);


    }


}
