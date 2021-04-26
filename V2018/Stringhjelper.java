package V2018;

public class Stringhjelper {
    public static void main(String[] args) {
        inneholder("STEIN", "EI");
    }

    static int inneholder(String s, String t){
        int sLen = s.length();
        int tLen = t.length();
        if (s.contains(t)){
            return 2;
        }
        return -1;
    }
}
