class wallsAndGates{
    // 286 Solution 1
public void wallsAndGates(int[][] rooms) {
    if(rooms.length == 0 || rooms[0].length == 0) return;
    int n = rooms.length;
    int m = rooms[0].length;
    
    LinkedList<Integer> que = new LinkedList<>();
    
    for(int i = 0;i<n;i++){
        for(int j = 0; j<m;j++){
            if(rooms[i][j] == 0){
                que.addLast(i*m + j);
            }
        }
    }
    
    int level = 0;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int idx = que.removeFirst();
            int r = idx / m;
            int c = idx % m;
            
            for(int d = 0;d< 4;d++){
                
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                
                if(x>=0 && y>=0 && x< n && y<m && rooms[x][y] == 2147483647 ){
                    rooms[x][y] = level + 1; 
                    que.addLast(x*m+y);
                }
            }
        }
        level++;
    }   
}

//286 Solution 2
public void wallsAndGates(int[][] rooms) {
    if(rooms.length == 0 || rooms[0].length == 0) return;
    int n = rooms.length;
    int m = rooms[0].length;
    
    LinkedList<Integer> que = new LinkedList<>();
    boolean[][] vis = new boolean[n][m];
    
    for(int i = 0;i<n;i++){
        for(int j = 0; j<m;j++){
            if(rooms[i][j] == 0){
                que.addLast(i*m + j);
                vis[i][j] = true;
            }
        }
    }
    
    int level = 0;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            int idx = que.removeFirst();
            int r = idx / m;
            int c = idx % m;
            
            rooms[r][c] = level;
            for(int d = 0;d< 4;d++){
                
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                
                if(x>=0 && y>=0 && x< n && y<m && !vis[x][y] && rooms[x][y] != -1){
                    vis[x][y] = true;
                    que.addLast(x*m+y);
                }
            }
        }
        level++;
    }   
}

}