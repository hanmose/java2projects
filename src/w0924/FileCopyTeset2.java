package w0924;

import java.io.*;

public class FileCopyTeset2 {

    public static void  copyFile() throws IOException {

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;

        fr = new FileReader("D:/File Test/MyData1.txt");
        br = new BufferedReader(fr);
        fw = new FileWriter("D:/File Test/Copyfile1.txt");
        String line;

        while ((line = br.readLine()) != null) {
            fw.write(line + "\n");
        }

        System.out.println("File not found");

        System.out.println("한 줄을 읽어올 수 없습니다.");


        br.close();
        fw.close();
        System.out.println("복사가 완료 되었습니다");
        System.out.println("reader와 writer가 close되지 못했습니다.");
    }


    public static void main(String[] args) {

        try {
            copyFile();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
