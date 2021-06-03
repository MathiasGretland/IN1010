package interfaceRepetisjon;

public class Tollvesenet {
    public static void main(String[] args) {
        Importavgiftspliktig [] alleImpPliktVarer = new Importavgiftspliktig[100];

        int antall = 0;
        Importavgiftspliktig denne;
        denne = new Bil("KEKW420", 154252);
        alleImpPliktVarer[antall] = denne;
        antall++;
        FastOst cheddar = new FastOst(15, "Cheddar", 23, 2000);
        alleImpPliktVarer[antall] = cheddar;
        antall++;

        int totalAvgifter = 0;
        for (Importavgiftspliktig den : alleImpPliktVarer){
            if (den != null){
                totalAvgifter += den.avgift();
            }
        }
        System.out.println("Sum av avgifter: " + totalAvgifter);

    }
}
