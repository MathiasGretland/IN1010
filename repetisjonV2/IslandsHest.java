package repetisjonV2;

public class IslandsHest extends Hest implements KanToelte, KanPasse{

    public IslandsHest(String n, int a) {
        super(n, a);
    }

    @Override
    public void pass() {
        System.out.println("PASS");
    }

    @Override
    public void toelt() {
        System.out.println("TØELT");
    }
}
