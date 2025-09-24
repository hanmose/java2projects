package w0924;

import java.io.*;

public class FileCopyTeset1 {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("D:/File Test/MyData1.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("D:/File Test/Copyfile1.txt");
            String line;

            while ((line = br.readLine())!=null){
                fw.write(line+"\n");
            }

        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("File not found");
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("한 줄을 읽어올 수 없습니다.");
        }

        try {
            br.close();
            fw.close();
            System.out.println("복사가 완료 되었습니다");
        } catch (IOException e) {
            System.out.println("reader와 writer가 close되지 못했습니다.");
        }

    }
}
