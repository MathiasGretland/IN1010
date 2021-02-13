public class TestResepter {
    public static void main(String[] args) {
        Narkotisk morfin = new Narkotisk("Morfin", 1200, 1, 1.2,10);
        Vanedannende opioder = new Vanedannende("Opioder", 1800, 1, 2,12);
        Lege anton = new Lege("Anton");
        BlaaResept blaa = new BlaaResept(morfin, anton, 12, 4);
        Militerresept militia = new Militerresept(opioder,anton,18,7);
        PResept pr = new PResept(opioder,anton,13);

        /*
        //Tester for blå resept
        System.out.println(blaa.hentLegemiddel());
        System.out.println(blaa.hentId());
        System.out.println(blaa.hentLege());
        System.out.println(blaa.hentPasientId());
        System.out.println(blaa.hentReit());
        System.out.println(blaa.bruk());
        System.out.println(blaa.farge());
        System.out.println(blaa.prisAaBetale());

        //Tester for Militærresept
        System.out.println(militia.hentLegemiddel());
        System.out.println(militia.hentId());
        System.out.println(militia.hentLege());
        System.out.println(militia.hentPasientId());
        System.out.println(militia.hentReit());
        System.out.println(militia.bruk());
        System.out.println(militia.farge());
        System.out.println(militia.prisAaBetale());

        //Tester for PResept
        System.out.println(pr.hentLegemiddel());
        System.out.println(pr.hentId());
        System.out.println(pr.hentLege());
        System.out.println(pr.hentPasientId());
        System.out.println(pr.hentReit());
        System.out.println(pr.bruk());
        System.out.println(pr.farge());
        System.out.println(pr.prisAaBetale());
         */

        System.out.println(blaa.toString());
        System.out.println();
        System.out.println(militia.toString());
        System.out.println();
        System.out.println(pr.toString());
    }
}
