package oblig0;

public class BilBruk3 {
    public static void main(String[] args) {
        Bil3 bil = new Bil3("AX26127");
        Person oleksandr = new Person(bil);
        oleksandr.nummer();
    }
}
