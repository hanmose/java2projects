package w0827;

public class Dynamic {
    public static void main(String[] args) {
        int i;
        int j;
        int[][] Dynamic = {{1, 2}, {3, 4, 5}, {6}};
        for (i = 0; i < Dynamic.length; i++) {
            for (j=0;j <Dynamic[i].length;j++) {
                System.out.printf("%d", Dynamic[i][j]);
            }
            System.out.println();
        }
    }
}
