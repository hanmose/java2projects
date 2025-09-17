package production.w0903;

import java.util.Scanner;

public class Plus {
    public static int Plus(int one,int two) {
        return one+two;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int continues = 0;

        while (continues!=-1) {
            System.out.println("정수1 입력: ");
            int a = sc.nextInt();
            System.out.println("정수2 입력: ");
            int b = sc.nextInt();

            System.out.println(Plus(a, b));
            System.out.println("Continue?");
            continues = sc.nextInt();
        }
        sc.close();
    }
}
