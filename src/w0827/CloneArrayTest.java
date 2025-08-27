package w0827;

import java.util.Arrays;

public class CloneArrayTest {
    public static void main(String[] args) {
//  복제가 아닌 경우
        String[] Ori = {"January","February","March","April"};
        String[] OriOri = Ori;

        Ori[1] = "Thor";
        OriOri[2] = "IronMan";

        System.out.println(Arrays.toString(Ori));
        System.out.println(Arrays.toString(OriOri));

//  복제되는 경우

        String[] OOri = {"January","February","March","April"};
        String[] Nori = OOri.clone();

        Nori[0] = "Spiderman";
        Nori[2] = "Captin";

        System.out.println(Arrays.toString(OOri));
        System.out.println(Arrays.toString(Nori));
    }
}
