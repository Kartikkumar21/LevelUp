// edge = {{u,v,w}....}
    public static void bellmanFordAlgo(int[][] edges,int N,int src){
        int[] dis = new int[N];
        Arrays.fill(dis,(int)1e8);
        dis[src] = 0;
        boolean negativeCycle = false;

        for(int i=1;i <= N;i++){
            
            boolean isAnyUpdate = false;
            
            int[] ndis = new int[N];
            for(int i=0;i<N;i++) ndis[i] = dis[i];

            for(int[] e : edges){
                if(dis[e[0]]!= (int)1e8 && dis[e[0]] + e[2] < ndis[e[1]]){
                    ndis[e[1]] = dis[e[0]] + e[2];
                    isAnyUpdate = true;
                }
            }

            dis = ndis;


            if(isAnyUpdate && i == N) negativeCycle = true;
            if(!isAnyUpdate && i < N) break;
        }
    }

    public static void bellmanFordAlgo_02(int[][] edges,int N,int src){
        int[] dis = new int[N];
        Arrays.fill(dis,(int)1e8);
        dis[src] = 0;
        boolean negativeCycle = false;

        for(int i=1;i <= N;i++){
            boolean isAnyUpdate = false;
            
            for(int[] e : edges){
                if(dis[e[0]]!= (int)1e8 && dis[e[0]] + e[2] < dis[e[1]]){
                   dis[e[1]] = dis[e[0]] + e[2];
                   isAnyUpdate = true;
                }
            }
            if(isAnyUpdate && i == N) negativeCycle = true;
            if(!isAnyUpdate && i < N) break;
        }
    }