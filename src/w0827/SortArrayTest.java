package w0827;

import java.util.Arrays;
import java.util.Collections;

public class SortArrayTest {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 4, 1, 6, 7, 3, 9 };
        String[] strArr ={"동해물과","백두산이","마르고","닳도록","하느님이","보우하사"};

//      오름차순 정렬
        Arrays.sort(arr);

        for (int num : arr) {
            System.out.print(num + "\t");
        }
        System.out.println();

//      내림차순 정렬
        Arrays.sort(strArr, Collections.reverseOrder());
        for (String str : strArr) {
            System.out.print(str + "\t");
        }
    }
}
