 public static void BFS_01(int src,boolean[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        boolean cycle = false;
        while(que.size()!=0){
            int vxt = que.removeFirst();
            
            if(vis[vtx]){
                cycle = true;
                continue;
            }

            vis[vtx] = true;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    que.addLast(e.v);
                }
            }
        }
    }

    public static void BFS_02(int src,boolean[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        que.addLast(null);

        boolean cycle = false;
        int level = 0;

        while(que.size() != 1){
            int vxt = que.removeFirst();
            
            if(vis[vtx]){
                cycle = true;
                continue;
            }

            if(vtx == dest){
                System.out.println(level);
            }

            vis[vtx] = true;
            
            for(Edge e: graph[vtx]){
                if(!vis[e.v]){
                    que.addLast(e.v);
                }
            }

            if(que.getFirst() == null){
                level++;
                que.addLast(que.removeFirst());
            }
        }
    }

    public static void BFS_03_WithCycle(int src,boolean[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        boolean cycle = false;
        int level = 0;
        
        int[] dis = new int[N];

        while(que.size() != 0){
            int size = que.size();
            while(size-->0){
                int vxt = que.removeFirst();
            
                if(vis[vtx]){
                    cycle = true;
                    continue;
                }
                
                dis[vtx] = level;

                vis[vtx] = true;
                for(Edge e: graph[vtx]){
                    if(!vis[e.v]){
                        que.addLast(e.v);
                    }
                }                
            }
            level++;
        }
    }

    public static void BFS_04_WithoutCycle(int src,boolean[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;

        int level = 0;
        
        int[] dis = new int[N];

        while(que.size() != 0){
            int size = que.size();
            while(size-->0){
                int vxt = que.removeFirst();
                
                dis[vtx] = level;
                for(Edge e: graph[vtx]){
                    if(!vis[e.v]){
                        vis[e.v] = true;
                        que.addLast(e.v);
                    }
                }                
            }
            level++;
        }
    }