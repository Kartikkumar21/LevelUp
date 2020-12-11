import java.util.*;
class flodfill4{
    static int[][] vis=new int[10][10];
    static int[][] dir={{1, 0}, {0, -1}, {-1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    static String[] dirs={"D", "L", "U", "R", "S", "N", "E", "W"};
    public static int floodfill_jump(int sr, int sc, int er, int ec, string ans){
    if (sr == er && sc == ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    vis[sr][sc] = 1;
    for (int jump = 1; jump <= max(er, ec); jump++)
    {
        for (int d = 0; d < dir.size(); d++)
        {
            int r = sr + jump * dir[d][0];
            int c = sc + jump * dir[d][1];

            if (r >= 0 && c >= 0 && r < vis.size() && c < vis[0].size() && vis[r][c] == 0)
                count += floodfill_jump(r, c, er, ec, ans + dirS[d] + toString(jump) + " ");
        }
    }

    vis[sr][sc] = 0;
    return count;
}

    public static void main(String[] args){
        System.out.print(floodfill_jump(0,0,2,2,""));
    }
}