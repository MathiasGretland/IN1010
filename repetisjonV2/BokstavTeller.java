package repetisjonV2;

public class BokstavTeller implements Runnable{

    BokstavTellerMonitor bokstavTellerMonitor;

    BokstavTeller(BokstavTellerMonitor monitor){
        bokstavTellerMonitor = monitor;

    }

    @Override
    public void run() {
        int teller = 0;
        char bokstav = bokstavTellerMonitor.bokstav;
        int lengde = bokstavTellerMonitor.listeMedOrd.size();
        for (int y = 0; y < lengde; y++){
            String ord = bokstavTellerMonitor.hentOrd();
            String ordLower = ord.toLowerCase();
            for (int i = 0; i < ordLower.length(); i++){
                if (ordLower.charAt(i) == bokstav){
                    teller++;
                }
            }
        }
        System.out.println(teller);
    }
}
