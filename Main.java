import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter number of Rows: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        System.out.print("Enter number of Columns: ");
        int M = sc.nextInt(); 
        int[][] arr = new int[N][M];
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<M;j++)
            {
                System.out.print("Enter for (" + (i+1) + "," + (j+1) + "): ");
                arr[i][j] = sc.nextInt();
            }
        }
    }
}