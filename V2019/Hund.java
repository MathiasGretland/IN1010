package V2019;

class Hund implements Comparable<Hund> {
    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;

    Hund(Kull k, String navn, Tidspunkt fodt) {
        this.navn = navn;
        mittKull = k;
        minFodselstid = fodt;
    }

    @Override
    public int compareTo(Hund h) {
        return minFodselstid.compareTo(h.minFodselstid);
    }
    public Hund mor() {
        return mittKull.mor;
    }
    public Hund far () {
        return mittKull.far;
    }
    public boolean erHelsosken(Hund h) {
        if (mor() != null && far() != null && mor() == h.mor() && far() == h.far()){
            return true;
        }
        return false;
    }
    public boolean erHalvsosken(Hund h) {
        if (erHelsosken(h)){
            return false;
        }
        if (far() != null && far() == h.far()){
            return true;
        }
        if (mor() != null && mor() == h.mor()){
            return true;
        }
        return false;
    }
    public Hund finnEldsteKjenteOpphav() {
        //Basissteg
        if (mor() == null && far() == null){
            return this;
        }

        if (mor() == null){
            return far().finnEldsteKjenteOpphav();
        }
        if (far() == null){
            return mor().finnEldsteKjenteOpphav();
        }
        Hund eldstePaaMorSide = mor().finnEldsteKjenteOpphav();
        Hund eldstePaaFarSide = far().finnEldsteKjenteOpphav();

        if (eldstePaaMorSide.compareTo(eldstePaaFarSide) < 0){
            return eldstePaaMorSide;
        }
        else{
            //Antar at hvis de er like gamle så returnerer vi bare den på far siden.
            return eldstePaaFarSide;
        }
    }
}
