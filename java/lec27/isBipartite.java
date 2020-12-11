class isBipartite{
     public boolean isBipartite(int[][] graph,int[] markedColor,int src){  
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        
        int color = 0;
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                
                int vtx = que.removeFirst();
                
                if(markedColor[vtx] != -1){
                    
                    if(markedColor[vtx] != color){  // phele red tha ab white se mark krne agye.
                        return false; 
                    }    
                    continue;
                }
                
                markedColor[vtx] = color;
                for(int e: graph[vtx]){
                    if(markedColor[e] == -1){
                        que.addLast(e);
                    }
                }
            }
            color = (color + 1) % 2;
        }
        
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] markedColor = new int[N];
        Arrays.fill(markedColor, -1);
        
        boolean ans = true;
        for(int i=0;i<N;i++){
            if(markedColor[i] == -1){
                ans = isBipartite(graph,markedColor,i);
                
                if(!ans) return false;
            }
        }
        
        return true;
    }
}
}