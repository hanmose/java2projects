package production.w0917;

import java.util.Scanner;

public class PassWord {

    public static boolean checkPassword(String pwd) {

        if (pwd.length() < 8) {
            return false;
        }

        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if(!Character.isAlphabetic(c))
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("패스워드 입력");
        String pwd = scanner.nextLine();

        if (checkPassword(pwd)) {
            System.out.println("생성 성공");
        }
        else System.out.println("생성 실패");
    }
}
