class BestMeetingPoint{
    //Leetcode 296
public void BFS(int i,int j,int[][] grid,int[][] dir,int[][] dis){
    int n = grid.length;
    int m = grid[0].length;
    
    boolean[][] vis = new boolean[n][m];
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(i*m+j);
    vis[i][j] = true;
    
    int level = 0;
    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int idx = que.removeFirst();
            int r = idx / m;
            int c = idx % m;
            
            dis[r][c] += level;
            
            for(int d = 0;d < 4; d++){
                int x = r + dir[d][0];
                int y = c + dir[d][1];
                
                if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y]){
                    vis[x][y] = true;
                    que.addLast(x * m + y);
                }
            }
        }
        
        level++;
    }
}

public int minTotalDistance(int[][] grid) {
   if(grid.length == 0 || grid[0].length == 0) return 0; 
    int n = grid.length;
    int m = grid[0].length;
    
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] dis = new int[n][m];
    
    for(int i = 0;i<n;i++){
        for(int j = 0; j<m;j++){
            if(grid[i][j] == 1){
                BFS(i,j,grid,dir,dis);            
            }
        }
    }
    
    int ans = (int)1e8;
    for(int i = 0;i<n;i++){
        for(int j = 0; j<m;j++){
            ans = Math.min(ans , dis[i][j]);
        }
    }
    
    return ans;
}

public int getInter(ArrayList<Integer> list){
    Collections.sort(list);
    
    int res = 0;
    int i = 0;
    int j = list.size() - 1;
    while( i < j ){
        res += list.get(j--) - list.get(i++);
    }
    
    return res;
    
}

public int minTotalDistance(int[][] grid) {
   if(grid.length == 0 || grid[0].length == 0) return 0; 
    int n = grid.length;
    int m = grid[0].length;
    
    ArrayList<Integer> xpoints = new ArrayList<>();
    ArrayList<Integer> ypoints = new ArrayList<>();
    
    for(int i = 0;i<n;i++){
    for(int j = 0; j<m;j++){
        if(grid[i][j] == 1){
            xpoints.add(i);
            ypoints.add(j);
        }
     }
   }
    return getInter(xpoints) + getInter(ypoints);
}
}