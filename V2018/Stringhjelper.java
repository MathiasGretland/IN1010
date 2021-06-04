package V2018;

public class Stringhjelper {

    public static int inneholder(String s, String t){
        String setningLower = s.toLowerCase();
        String tekstLower = t.toLowerCase();
        int setningLengde = setningLower.length();
        int tekstLengde = tekstLower.length();
        if (setningLengde < tekstLengde){
            return -1;
        }

        for (int i = 0; i <= setningLengde-tekstLengde; i++){
            boolean sant = true;
            for (int y = 0; y < tekstLengde; y++){
                if (setningLower.charAt(i+y) != tekstLower.charAt(y)){
                    sant = false;
                }
            }
            if (sant){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(inneholder("STEIN", "EI"));
    }
}
