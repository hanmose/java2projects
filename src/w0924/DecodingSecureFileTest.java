package w0924;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DecodingSecureFileTest {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = "";
        String Decode = "";

        try {
            fr = new FileReader("D:/File Test/secure1.txt");
            br = new BufferedReader(fr);
            while ((line = br.readLine())!=null){
                for (int i = 0; i < line.length(); i++){

                    int code = line.charAt(i);
                    code -= 100;
                    Decode += (char)code;
                }
                System.out.println(Decode+"\r\n");
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
