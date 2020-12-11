// https://www.lintcode.com/problem/number-of-distinct-islands/
HashSet<String> map = new HashSet<>();
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    char[] dirS = {'r','d','l','u'};
    String shape = "";
    int n=0,m=0;
    
    public void dfs(int i,int j,int[][] grid){
        
        grid[i][j] = 0;
        for(int d = 0;d<4;d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r>=0 && c>=0 && r< n && c<m && grid[r][c] == 1){
                shape += dirS[d];
                dfs(r,c,grid);
                shape += "b";
            }
        }
         
    }
    
    public int numDistinctIslands(int[][] grid) {
        if(grid.length ==0 || grid[0].length == 0) return 0;
        n = grid.length;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    map.add(shape);
                    shape = "";
                }
            }
        }
        
        return map.size();
        
    }
