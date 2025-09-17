package production.w0820;

public class Array1Test {
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        arr1[0] =10;
        arr1[1] =20;
        arr1[2] =30;
        arr1[3] =40;

        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }

        int[] arr2 = {1,3,5,7};

        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }

        int[][] arr3 = new int[2][3];
        arr3[0][0] =1;
        arr3[0][1] =2;
        arr3[1][2] =6;
        int[][] arr4 = {{1,2,3},{4,5,6}};

    }
}
