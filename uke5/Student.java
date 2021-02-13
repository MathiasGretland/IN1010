package uke5;

abstract class Student {
    private String navn;

    public Student(String navn){
        this.navn = navn;
    }

    public abstract void studer() throws GidderIkkeUnntak;
}
