int boardPath(int sp, int ep, vector<int> &dp)
{
    if (sp == ep)
    {
        return dp[sp] = 1;
    }
    if (dp[sp] != 0)
        return dp[sp];

    int count = 0;
    for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++)
    {
        count += boardPath(sp + dice, ep, dp);
    }

    return dp[sp] = count;
}

int boardPathDP(int sp, int ep, vector<int> &dp)
{
    for (sp = ep; sp >= 0; sp--)
    {
        if (sp == ep)
        {
            dp[sp] = 1;
            continue;
        }

        for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++)
            dp[sp] += dp[sp + dice];
    }

    return dp[0];
}

int boardPath_Opti(int n)
{
    list<int> ll;

    for (int si = n; si >= 0; si--)
    {
        if (ll.size() <= 1)
            ll.push_front(1);
        else if (ll.size() <= 6)
            ll.push_front(2 * ll.front());
        else
        {
            ll.push_front(2 * ll.front() - ll.back());
            ll.pop_back();
        }
    }

    return ll.front();
}