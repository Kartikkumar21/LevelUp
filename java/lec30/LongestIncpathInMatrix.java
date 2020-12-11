class LongestIncpathInMatrix{
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length; if(n==0) return 0;
        int m = matrix[0].length;if(m==0) return 0;
 
        int[][] indegree=new int[n][m];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int d=0;d<4;d++){
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];
                    if(x>=0 && y>=0 && x < n && y < m && matrix[x][y] > matrix[i][j]) indegree[x][y]++;
                }
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
               if(indegree[i][j]==0) que.addLast(i*m+j);   

        int level = 0;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int idx = que.removeFirst();
                int i = idx / m;
                int j = idx % m;
    
                for(int d=0;d<4;d++){
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];
                    if(x>=0 && y>=0 && x < n && y < m && matrix[x][y] > matrix[i][j] && --indegree[x][y] == 0) que.addLast(x*m+y);
                }                
            }
            level++;
        }

        return  level;
    }
}