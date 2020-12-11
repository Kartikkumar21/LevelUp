import java.util.*;
class flodfill4{
    static int[][] vis=new int[10][10];
    static int[][] dir={{1, 0}, {0, -1}, {-1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    static String[] dirs={"D", "L", "U", "R", "S", "N", "E", "W"};
    public static int flodfill(int sr,int sc,int er,int ec,String ans){
        if(sr==er || sc==ec){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        vis[sr][sc]=1;
        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            if(r >= 0 && c >= 0 && r < vis.length && c < vis[0].length && vis[r][c] == 0)
                count+=flodfill(r,c,er,ec,ans+dir[i]);
        }
        vis[sr][sc]=0;
        return count;
    }
    public static void main(String[] args){
        System.out.print(flodfill(0,0,2,2,""));
    }
}