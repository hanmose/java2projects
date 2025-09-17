package production.w0903;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RockScissorsPaper {
    public static void main(String[] args) {
        String[] result = new String[10000];
        String ComA, ComB;
        int aWin,bWin,noWin;
        String[] strArr = {"가위", "바위", "보"};

        for (int i = 0; i < 10000; i++) {
            Random rand = new Random();
            ComA = strArr[rand.nextInt(strArr.length)];
            ComB = strArr[rand.nextInt(strArr.length)];

            if(ComA.equals("가위")){
                if(ComB.equals("가위"))
                    result[i] = "없음";
                else if(ComB.equals("바위"))
                    result[i] = "B";
                else if(ComB.equals("보"))
                    result[i] = "A";
            } else if (ComA.equals("보")) {
                if(ComB.equals("가위"))
                    result[i] = "B";
                else if(ComB.equals("바위"))
                    result[i] = "A";
                else if(ComB.equals("보"))
                    result[i] = "없음";
            } else if (ComA.equals("바위")) {
                if(ComB.equals("가위"))
                    result[i] = "A";
                else if(ComB.equals("바위"))
                    result[i] = "없음";
                else if(ComB.equals("보"))
                    result[i] = "B";
            }
        }
        aWin = Collections.frequency(Arrays.asList(result),"A");
        bWin = Collections.frequency(Arrays.asList(result),"B");
        noWin = Collections.frequency(Arrays.asList(result),"없음");

        System.out.println("A승: "+aWin);
        System.out.println("B승: "+bWin);
        System.out.println("무: "+noWin );
    }
}
