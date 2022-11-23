import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int INF = 9;
        Scanner sc = new Scanner(new File("In0303.txt"));
        int n = sc.nextInt();
        int[][] list = new int[n + 1][n + 1];
        String line;
        String top;
        int source = 0;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                list[i][j] = INF;
            }
        }

        while(sc.hasNextLine()){
            line = sc.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            while(tokenizer.hasMoreTokens()){
                top = tokenizer.nextToken();
                StringTokenizer tokenizer2 = new StringTokenizer(top, " ");
                int dest = Integer.parseInt(tokenizer2.nextToken());
                int wageOfVertex = Integer.parseInt(tokenizer2.nextToken());
                list[source][dest] = wageOfVertex;
            }
            source++;
        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }


        kruskal k = new kruskal(n,INF);
        k.kruskalMTS(list);
        k.close();
    }
}