package production.w0827;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReverseTest {
    public static void main(String[] args) {
        String[] strArr = {"월","화","수","목","금","토","일"};
        System.out.println("처음 배열"+ Arrays.toString(strArr));

        Collections.reverse(Arrays.asList(strArr));

        System.out.println("역순 배열"+ Arrays.toString(strArr));
    }
}
