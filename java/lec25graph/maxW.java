import java.util.ArrayList;

public class maxW{

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

    public static class pair{
        String path = "";
        int weight = 0;
        boolean isDestiHit = false;

        pair(String path,int weight,boolean isDestiHit){
            this.path = path;
            this.weight = weight;
            this.isDestiHit = isDestiHit;
        }
    }

    public static pair maxWeightPath(int src,int dest,boolean[] vis){
        if(src==dest){
            return new pair(src + "",0,true);
        }

        vis[src] = true;
        
        pair myAns = new pair("",0,false);
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                pair recAns = maxWeightPath(e.v,dest,vis);
                if(recAns.isDestiHit && recAns.weight + e.w > myAns.weight){
                    myAns.weight = recAns.weight + e.w;
                    myAns.path = src + " " + recAns.path;
                    myAns.isDestiHit = true;
                }
            }
        }

        vis[src] = false;
        return myAns;
    }
    public static void constructGraph(){
        for(int i = 0;i<N;i++) graph[i] = new ArrayList<Edge>();

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        // removeVtx(3);
        boolean[] visited=new boolean[N];
        MaxWie(0,6,visited,"",0);
        // display();
    }

    public static void main(String[] args){
        constructGraph();

    }



}