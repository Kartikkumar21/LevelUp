import java.util.ArrayList;

public class hamiltonPathCycle{

    public static class Edge{
        int v = 0;
        int w = 0;

        public Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;
    
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i + " -> ");
            for(Edge e: graph[i]){
                System.out.print("(" + e.v + ", " + e.w + "), ");
            }

            System.out.println();
        }
    }

    public static int hamintonianPath(int src,int osrc,boolean[] vis,int edgeCount,String psf){
        if(edgeCount == N - 1){
            psf += src;
            int idx = searchVtx(src,osrc);
            
            if(idx != -1) System.out.println("Cycle : " + psf);
            else  System.out.println("Path : " + psf);

            return 1;
        }
        vis[src] = true;
        int count = 0;
        for(Edge e: graph[src]){
            if(!vis[e.v])
              count += hamintonianPath(e.v,osrc,vis,edgeCount + 1,psf + src + " "); 
        }
        vis[src] = false;
        return count;
    }

    public static void constructGraph(){
        for(int i = 0;i<N;i++) graph[i] = new ArrayList<Edge>();

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(2,5,10);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        boolean[] visited=new boolean[N];
        ArrayList<Integer> psf=new ArrayList<>();
        System.out.print(hamiltonianPathandCycle(0,psf,visited,0));
    }

    public static void main(String[] args){
        constructGraph();

    }



}