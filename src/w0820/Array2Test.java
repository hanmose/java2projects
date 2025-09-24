package w0820;

public class Array2Test {
    public static void main(String[] args) {
        int[][] arr1 = new int[2][3];
        int cnt = 1;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = cnt;
                cnt++;
            }

            int[][] arr2 = {{1,2,3},{4,5,6}};
            for (int k = 0; k < arr2.length; k++) {
                for (int l = 0; l < arr2[k].length; l++) {
                    System.out.print(arr2[k][l] + " ");
                }
            }
        }
    }
}
