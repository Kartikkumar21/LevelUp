// leetcode 130
class Solution {
 public void SurroundedRegionDFS(char[][] grid,int r,int c,int[][] dir){
        grid[r][c] = '$';
        for(int d = 0 ;d < 4 ; d++){
            int x = r + dir[d][0];
            int y = c + dir[d][1];

            if( x>=0 && y>=0 && x < grid.length && y < grid[0].length && grid[x][y] == 'O') 
               SurroundedRegionDFS(grid,x,y,dir);
        }
    }


    public void solve(char[][] grid) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i ==0 || j == 0 || i == grid.length-1 || j == grid[0].length - 1){
                    if(grid[i][j] == 'O')
                       SurroundedRegionDFS(grid,i,j,dir);
                }

            }
        }

        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'O') grid[i][j] = 'X';
                else if(grid[i][j] == '$') grid[i][j] = 'O';
            }
        }
    }
}