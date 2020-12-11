class pathPair
{
public:
    string path;
    int len;

    pathPair(string path, int len)
    {
        this->path = path;
        this->len = len;
    }
};

pathPair floodfillShortestPath_jump(int sr, int sc, int er, int ec)
{
    if (sr == er && sc == ec)
    {
        pathPair p("", 0);
        return p;
    }

    int count = 0;
    vis[sr][sc] = 1;
    pathPair ans("", 1e8);
    for (int jump = 1; jump <= max(er, ec); jump++)
    {
        for (int d = 0; d < dir.size(); d++)
        {
            int r = sr + jump * dir[d][0];
            int c = sc + jump * dir[d][1];

            if (r >= 0 && c >= 0 && r < vis.size() && c < vis[0].size() && vis[r][c] == 0)
            {
                pathPair recAns = floodfillShortestPath_jump(r, c, er, ec);
                if (recAns.len + 1 < ans.len)
                {
                    ans.len = recAns.len + 1;
                    ans.path = dirS[d] + to_string(jump) + " " + recAns.path;
                }
            }
        }
    }

    vis[sr][sc] = 0;
    return ans;
}

void pathSet()
{
    int n = 3;
    int m = 3;
    vis.resize(n, vector<int>(m, 0));
    // cout << floodfill(0, 0, 2, 2, "") << endl;
    // cout << floodfill_jump(0, 0, 2, 2, "") << endl;
    pathPair ans = floodfillShortestPath_jump(0, 0, 2, 2);
    cout << ans.path << " -> " << ans.len << endl;
}