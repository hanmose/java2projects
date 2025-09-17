package production.w0827;

public class ggu {
    public static void main(String[] args) {
        int one,two;

        for (one = 2; one <=9; one++){
            for (two = 1; two <= 9; two++){
                System.out.printf("%d * %d = %2d ", one,two,one*two);
            }
            System.out.println("");
        }
    }
}
