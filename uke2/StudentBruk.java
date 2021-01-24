package uke2;

public class StudentBruk {
    public static void main(String[] args) {
        Student joakim = new Student("Joakim", 5,2);
        Student kristin = new Student("Kristin", 10, 3);
        Student dag = new Student("Dag", 8, 4);

        for (int i = 0; i < 3; i++) {
            joakim.leggTilQuizScore((i + 1) * 2);
            kristin.leggTilQuizScore((i + 1) * 3);
            dag.leggTilQuizScore(i + 1);
        }

        skrivUtStudent(joakim);
        skrivUtStudent(kristin);
        skrivUtStudent(dag);
    }
    public static void skrivUtStudent(Student student){
        System.out.println("--------------");
        System.out.println(student.hentNavn());
        System.out.println("Total score: " + student.hentTotalScore());
        System.out.println("Gjennomsitt score: "  + student.hentGjennomsnittligScore());
    }
}
