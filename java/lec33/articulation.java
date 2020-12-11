import java.util.*;
class articulation{
    static int[] low = new int[N];
    static int[] disc = new int[N];
    static boolean[] AP = new boolean[N];
    static boolean[] vis = new boolean[N];
    static int time = 0;
    static int rootCalls = 0;

    public static void dfs_APB(int src,int par){
        low[src] = disc[src] = time++;
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){

                if(par == -1) rootCalls++;

                dfs_APB(e.v,src);

                if(disc[src] <= low[e.v]) AP[src] = true;
                if(disc[src] < low[e.v]) System.out.println("AE : " + src + " - " + e.v);
                
                low[src] = Math.min(low[src],low[e.v]);
            }else if(e.v != par)
                low[src] = Math.min(low[src],disc[e.v]);
        }
    }

    public static void APB(){
        int componentsCount = 0;
        for(int i=0;i<N;i++){
            if(!vis[i]){
                dfs_APB(i,-1);
                componentsCount++;

                if(rootCalls == 1) AP[i] = false;
                rootCalls = 0;
            }
        }
    }

}