package w0924;

import java.io.*;

public class DecodingSecureFileTest
{
    public static void main(String[] args)
    {
        FileReader fr = null;
        BufferedReader br=null;
        FileWriter fw = null;
        String read1;


        try {
            fr=new FileReader("D:/File Test/secure1.txt");
            br=new BufferedReader(fr);
            fw=new FileWriter("D:/File Test/secure1.txt");

            while((read1=br.readLine())!=null)
            {
                System.out.println("읽은 줄: "+read1);
                String read2="";
                for(int i=0; i<read1.length(); i++)
                {
                    int code=(int)read1.charAt(i);
                    code-=100;
                    read2+=(char)code;
                }
                fw.write(read2+"\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileReader Fail");
        } catch (IOException e) {
            System.out.println("FileWriter Fail");
        }

        try
        {
            fw.close();
            fr.close();
            System.out.println("Text Decoding Success");
        } catch (IOException e) {
            System.out.println("fw,fr Closing Error");
        }
    }
}
