package uke2;

public class Student {
    private String navn;
    private int totalScore;
    private int deltatt;

    public Student(String navn, int totalScore, int deltatt){
        this.navn = navn;
        this.totalScore = totalScore;
        this.deltatt = deltatt;
    }

    public String hentNavn(){
        return navn;
    }

    public void leggTilQuizScore(int score) {
        totalScore += score;
        deltatt ++;
    }

    public int hentTotalScore() {
        return totalScore;
    }

    public int hentGjennomsnittligScore(){
        return totalScore/deltatt;
    }


}
