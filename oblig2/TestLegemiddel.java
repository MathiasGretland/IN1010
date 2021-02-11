package oblig2;

public class TestLegemiddel {
    public static void main(String[] args) {
       Narkotisk morfin = new Narkotisk("Morfin", 1200, 1, 1.2,10);
       Vanlig paracet = new Vanlig("Paracet", 120, 1, 0.2);
       Vanedannende opioder = new Vanedannende("Opioder", 1800, 1, 2,12);
       System.out.println(morfin.toString());
        System.out.println();
        System.out.println(opioder.toString());
        System.out.println();
        System.out.println(paracet.toString());
    }
}
