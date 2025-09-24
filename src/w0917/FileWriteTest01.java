package w0917;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {
    public static void main(String[] args) {

        FileWriter fw = null;
        String line = null;
        try {
            fw = new FileWriter("D:/File Test/Mydata2.txt");
            line = "Hello";
            fw.write(line + "\n");

            line = "Mr,My yesterday";
            fw.write(line + "\n");

            line = "코난";
            fw.write(line + "\n");

        } catch (IOException e) {
            System.out.println("FileWriter Generation Error");
        }

        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("FileWriter Close Error");
        }
    }
}
