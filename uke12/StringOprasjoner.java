package uke12;

public class StringOprasjoner {
    public static void main(String[] args) {
        String str = "kattkukatt";
        System.out.println(antallSubStringer(str, "katt"));
        System.out.println(antallSubStringer(str, "ku"));
        System.out.println(antallSubStringer(str, "hund"));

        System.out.println();

        System.out.println(settInnStjerner("hello"));
        System.out.println(settInnStjerner("helllo"));
        System.out.println(settInnStjerner("helloo"));
        System.out.println(settInnStjerner(""));
        System.out.println(settInnStjerner("trollmannen"));
    }

    public static int antallSubStringer(String str, String sub){
        if (str.length() < sub.length()){
            return 0;
        }
        else if (str.substring(0, sub.length()).equals(sub)) {
            return 1 + antallSubStringer(str.substring(1), sub);
        }
        else {
            return antallSubStringer(str.substring(1), sub);
        }
    }

    public static String settInnStjerner (String str) {
        return settInnStjerner(str, "", '|');

    }

    private static String settInnStjerner(String str, String akk, char last) {
        if (str.length() == 0){
            return akk;
        }
        else if (str.charAt(0) == last) {
            return settInnStjerner(str.substring(1), akk + '*' + last, last);
        }
        else {
            return settInnStjerner(str.substring(1), akk + str.charAt(0), str.charAt(0));
        }
    }
}
