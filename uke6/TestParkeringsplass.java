package uke6;

public class TestParkeringsplass {
    public static void main(String[] args) {
        Parkeringsplass<Bil> bilParkeringsplass = new Parkeringsplass<>();
        Parkeringsplass<Motorsykkel> motorsykkelParkeringsplass = new Parkeringsplass<>();
        bilParkeringsplass.parker(new Bil("AY127912", 5));
        motorsykkelParkeringsplass.parker(new Motorsykkel("KEKW1337", 2));

    }
}
