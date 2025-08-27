package w0827;

import java.util.Random;

public class DDing {
    public static void main(String[] args) {
        String[] DDingUn = {"가장 큰 위험은 아무런 위험도 감수하지 않으려는 데 있다.","나는 내가 처한 환경의 산물이 아니다. 나는 내가 내린 결정의 산물이다."
        ,"어두운 밤이 지나면, 반드시 아침은 온다.","단순함이란 궁극의 정교함이다.","우리는 반복적으로 행동하는 그 자체다. 그러므로 탁월함은 행동이 아닌 습관이다."};

        int Num = (int)(Math.random()*5);
        System.out.println(DDingUn[Num]);
    }
}
