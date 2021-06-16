package eksamen4;

public class Skog {
    final int ANTSTIER;
    final int ANTKRYSS;
    Kryss[] kryssArray;
    Sti[] stiArray;


    Skog(int antStier, int antKryss){
        ANTSTIER = antStier;
        ANTKRYSS = antKryss;
        kryssArray = new Kryss[ANTKRYSS];
        stiArray = new Sti[ANTSTIER];
        for (int i = 0; i < ANTKRYSS; i++){
            kryssArray[i] = new Kryss();
        }
        for (int i = 0; i < ANTSTIER; i++){
            int tall = Trekk.trekkInt(1, 4);
            Kryss kryss1 = null;
            Kryss kryss2 = null;
            for (int y = 1; y <= 100; y++){
                kryss1 = kryssArray[Trekk.trekkInt(0, ANTKRYSS-1)];
                kryss2 = kryssArray[Trekk.trekkInt(0, ANTKRYSS-1)];
                if (!(kryss1.finnesVeiTil(kryss2, kryss1))){
                    break;
                }
                if (y == 100){
                    System.out.println("Programmet stopper");
                    System.exit(1);
                }
            }
            if (tall == 1){
                stiArray[i] = new Kjerreveier(Trekk.trekkInt(220, 2500), kryss1, kryss2);
                kryss1.leggTilSti(stiArray[i]);
                kryss2.leggTilSti(stiArray[i]);
            }
            if (tall == 2){
                stiArray[i] = new KjerreveierMedGodUtsikt(Trekk.trekkInt(220, 2500), kryss1, kryss2, Trekk.trekkInt(1,6));
                kryss1.leggTilSti(stiArray[i]);
                kryss2.leggTilSti(stiArray[i]);
            }
            if (tall == 3){
                stiArray[i] = new Naturstier(Trekk.trekkInt(220, 2500), kryss1, kryss2);
                kryss1.leggTilSti(stiArray[i]);
                kryss2.leggTilSti(stiArray[i]);
            }
            if (tall == 4){
                stiArray[i] = new NaturstierMedGodUtsikt(Trekk.trekkInt(220, 2500), kryss1, kryss2, Trekk.trekkInt(1,6));
                kryss1.leggTilSti(stiArray[i]);
                kryss2.leggTilSti(stiArray[i]);
            }
        }

    }

    public Kryss hentTilfeldigKryss(){
        return kryssArray[Trekk.trekkInt(0, ANTKRYSS-1)];
    }

    public Kryss hentTilfeldigStart(){
        while (true){
            Kryss kryss = kryssArray[Trekk.trekkInt(0, ANTKRYSS-1)];
            if (!(kryss.erIsolert())){
                return kryss;
            }
        }
    }

}
