package uke1;

public class Person {
    String navn;
    int alder;

    public Person(String n, int a) {
        navn = n;
        alder = a;
    }

    public void skrivUt() {
        System.out.println(navn + alder);
    }

    public void haBursdag() {
        alder += 1;
    }
}
