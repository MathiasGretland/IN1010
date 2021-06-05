package recursion;

public class Triangle {

    private int width;

    public Triangle(int width){
        this.width = width;
    }

    public int getArea(){
        if (width <= 0){
            return 0;
        }
        else if (width == 1){
            return 1;
        }
        else {
            Triangle smallerTriangle = new Triangle(width - 1);
            int smallerArea = smallerTriangle.getArea();
            return smallerArea + width;
        }
    }

    public static int pow2(int n){
        if (n <= 0){
            return 1;
        }
        else {
            int tall = pow2(n-1);
            return 2 * tall;
        }
    }

    public static int computeSumArray(int[] array, int lengde){
        if (lengde <= 0){
            return 0;
        }
        else {
            return (computeSumArray(array,lengde-1) + array[lengde-1]);
        }
    }

    public static int computeSumArray(int[] array){
        int [] ny = new int[array.length-1];
        for (int i = 0, j = 0; i < array.length; i++){
            int fjernes = array.length-1;
            if (i != fjernes){
                ny[j++] = array[i];
            }

        }
        int lengde = ny.length;
        if (lengde <= 0){
            return 1;
        }
        else {
            int teller = 0;
            return teller + (computeSumArray(ny) + array[lengde]);
        }
    }

    public static int fibonacci(int n){
        if (n <= 2){
            return 1;
        }
        return (fibonacci(n-1) + fibonacci(n-2));

    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(4);
        System.out.println(triangle.getArea());
        System.out.println(pow2(11));
        int[] array = new int[]{1,2,4,4,3,23,24,14};
        int sum = computeSumArray(array, 8);
        System.out.println(sum);
        int sum2 = computeSumArray(array);
        System.out.println(sum2);
        System.out.println(fibonacci(10));
    }
}
