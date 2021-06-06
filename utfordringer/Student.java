package utfordringer;

public class Student {
    String navn;

    Student(String navn){
        this.navn = navn;
    }

    @Override
    public String toString(){
        return navn;
    }
}
