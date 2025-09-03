package w0903;

import java.util.Scanner;

public class Calculator {
    public static int Calc(int one, int two, char symbol){
        int result = 0;
        switch(symbol){
            case '+': result = one+two;
            break;
            case '-': result = one-two;
            break;
            case '*': result = one*two;
            break;
            case '/': result = one/two;
            break;
            default:
                System.out.println("Error");
                break;
        }
        return  result;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = 0;
        int two = 0;
        char symbol = 0;
        System.out.println("정수1 입력: ");
        one = sc.nextInt();
        System.out.println("정수2 입력: ");
        two = sc.nextInt();
        System.out.println("연산기호 입력(e입력시 종료: ");
        symbol = sc.next().charAt(0);
        if(symbol=='e') {
            System.out.println("종료");
            return;
        }



        System.out.println(Calc(one, two, symbol));

    }
}
