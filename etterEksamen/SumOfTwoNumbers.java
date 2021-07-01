package etterEksamen;

public class SumOfTwoNumbers {
    public int sum(int a, int b){
        return (a+b);
    }

    public int tilSekunder(int timer){
        return ((timer*60)*60);
    }


    public int tredje(int a, int b){
        if (!(a+b <= 0)){
            return ((a+b)-1);
        }
        else {
            return 0;
        }
    }
}
