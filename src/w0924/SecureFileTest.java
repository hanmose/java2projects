package w0924;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SecureFileTest {
//      콘손(키보드) 입력 받은 메세지를 암호화시켜서 파일로 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null;
        String line = "";
        String outStream = "";
        String secureOutStr = "";

        try {
            fw = new FileWriter("D:/File Test/secure1.txt");
            while (true){
                System.out.println("Enter Message: ");
                line = sc.nextLine();
                if(line.equals("")){
                    break;
                }

                for (int i = 0; i < line.length(); i++) {
                    int code = line.charAt(i);
                    code += 100;
                    secureOutStr += (char)code;
                }
                fw.write(secureOutStr+"Fi\n");
            }
        } catch (IOException e) {
            System.out.println("File Write error");
        }

        try {
            fw.close();
            System.out.println("Generated Secure File");
        } catch (IOException e) {
            System.out.println("Close file error");
        }
    }
}
