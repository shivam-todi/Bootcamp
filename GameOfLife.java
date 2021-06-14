import java.util.*;

public class GameOfLife {

    public static boolean checkBounds(int i, int j, int N, int M)
    {
        if(j>=0 && j< M && i >= 0 && i< N) 
        {
            return true;
        }
        return false;
    }

    public static int countOfNeighbours(int currGen[][], int r, int c, int N, int M)
    {
        int dirx[] = {-1,0,1}, diry[]= {-1,0,1};
        int totalCountOfNeighbours = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(checkBounds(r + dirx[i],c + diry[j],N,M))
                {
                    totalCountOfNeighbours += currGen[r + dirx[i]][c + diry[j]];
                }
            }
        }
        totalCountOfNeighbours -= currGen[r][c];
        return totalCountOfNeighbours;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter number of Generations: ");
        int T = sc.nextInt(); 
        // System.out.print("Enter number of Rows: ");
        int N = sc.nextInt(); 
        // System.out.print("Enter number of Columns: ");
        int M = sc.nextInt(); 
        int[][] currGen = new int[N][M];
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<M;j++)
            {
                // System.out.print("Enter for (" + (i+1) + "," + (j+1) + "): ");
                currGen[i][j] = sc.nextInt();
            }
        }
        for (int test=1;test<=T;test++)
        {
            System.out.println();
            System.out.println("Generation #" + test);
            int[][] nextGen = new int[N][M];
            
            for (int r=1;r<N-1;r++)
            {
                for (int c=1; c<M-1; c++)
                {
                    int totalCountOfNeighbours = countOfNeighbours(currGen,r,c,N,M);
                    if (totalCountOfNeighbours == 3 && currGen[r][c] == 0)
                    {
                        nextGen[r][c] = 1;
                    }
                    else if ((totalCountOfNeighbours < 2 || totalCountOfNeighbours > 3) && currGen[r][c] == 1)
                    {
                        nextGen[r][c] = 0;
                    }
                    else
                    {
                        nextGen[r][c] = currGen[r][c];
                    }
                }
            }
            for (int i=0; i<N; i++)
            {
                for (int j=0; j<M; j++)
                {
                        System.out.print(nextGen[i][j]);
                }
                System.out.println();
            }
            currGen = nextGen;
        }
    }
}