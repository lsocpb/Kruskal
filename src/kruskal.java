import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class kruskal
{
    int vertex;
    int[] parent;
    int INF;
    PrintWriter write = new PrintWriter("Out0104.txt");
    public kruskal(int m, int max) throws FileNotFoundException {
        this.vertex = m;
        this.parent = new int[m+1];
        this.INF = max;
    }
    public int find(int i)
    {
        while(parent[i] != i)
            i= parent[i];
        return i;
    }
    public void union(int i,int j)
    {
        int a = find(i);
        int b = find(j);
        parent[a]=b;
    }
    public void kruskalMTS(int[][] tab)
    {
        int cost=0;
        for(int i = 1;i<vertex;i++)
            parent[i]=i;
        int vertexs = 0;
        while(vertexs < vertex-1)
        {
            int min=INF,a=-1,b=-1;
            for(int i=1;i<=vertex;i++)
            {
                for(int j=0;j<=vertex;j++)
                {
                    if(find(i)!= find(j) && tab[i][j] < min)
                    {
                        min = tab[i][j];
                        a=i;
                        b=j;
                    }
                }
            }if(a<0 || b<0)
                break;
            union(a,b);
            write.print(a + " "+ b + " " + "[" +min+"], " );
            cost +=min;
        }
        write.println("\n" + cost);
    }
    public void close()
    {
        write.close();
    }
}
