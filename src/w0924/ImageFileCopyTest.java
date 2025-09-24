package w0924;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//이미지파일은 1byte씩 입력받아서 1byte씩 출력해야한다.
public class ImageFileCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("C:/Users/AI-510-147/OneDrive - 한국폴리텍대학/그림/Night.jpg");
            fos = new FileOutputStream("C:/Users/AI-510-147/OneDrive - 한국폴리텍대학/그림/CopyNight.jpg");
            int ch;
            while ((ch = fis.read()) != -1){
                fos.write(ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Reading Character error");
        }

        try {
            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Closing File IOStream error");
        }
    }
}
