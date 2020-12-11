 //SCC.
//  kosaraju Algorithm
    public static void DFS_SSC(int src,boolean[] vis,ArrayList<Integer> path){
        vis[src] = true;
        for(int e : graph[src])
            if(!vis[e])
               DFS_SSC(e,vis,path);
        
        path.add(src);
    }

    public static void DFS_SSC2(int src,ArrayList<Integer>[] ngraph,boolean[] vis){
        vis[src] = true;
        System.out.print(src+" ");

        for(int e : ngraph[src])
            if(!vis[e])
               DFS_SSC(e,vis,path);
    }

    public static void SCC(){

        //Topological Order.
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[N];
        for(int i=0;i<N;i++){
            if(!vis[i])
               DFS_SSC(i,vis,path);
        }

        // Reverse graph.
        ArrayList<Integer>[] ngraph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int e: graph[i])
               ngraph[e].add(i);
        }

        //DFS over topologicalOrder.
        vis = new boolean[N];

        int count = 0;
        for(int i=path.size()-1;i>=0;i--){
            if(!vis[i]){
                count++;
                DFS_SSC2(i,ngraph,vis);
            }
        }
    }