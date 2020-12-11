// leetcode 695
class Solution {
    int n=0,m=0;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIslandDFS(int[][] grid,int r,int c) {
        grid[r][c]=0;
        int count=0;
        for(int d=0;d<dir.length;d++){
            int x=r+dir[d][0];
            int y=c+dir[d][1];
            
            if(x>=0 && y>=0 && x< n && y< m && grid[x][y] ==1){
                count+=maxAreaOfIslandDFS(grid,x,y);
            }
        }
        return count+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
     if(grid.length==0 || grid[0].length==0) return 0;
        
     n=grid.length;
     m=grid[0].length;
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    area=Math.max(area,numIslandsDFS(grid,i,j));
                }
            }
        }
        return area;
    }
}