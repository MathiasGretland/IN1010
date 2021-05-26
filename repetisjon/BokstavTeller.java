package repetisjon;

public class BokstavTeller implements Runnable {
    BokstavTellerMonitor monitor;

    public BokstavTeller(BokstavTellerMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        String ord = monitor.hentOrd();
        while (ord != null) {
            int teller = 0;
            String ordLower = ord.toLowerCase();
            for (int i = 0; i < ordLower.length(); i++){
                if (ordLower.charAt(i) == monitor.bokstav){
                    teller++;
                }
            }
            System.out.println("I " + ord + " er det: " + teller + " antall forekomster av bokstaven: " + monitor.bokstav);
            ord = monitor.hentOrd();
        }
    }
}