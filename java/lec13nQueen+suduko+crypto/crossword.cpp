vector<vector<char>> box = {{'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                            {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
                            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                            {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                            {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
                            {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
                            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                            {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

bool canPlaceWordH(int r, int c, string word)
{
    int l = word.length();
    int m = box[0].size();

    if(c==0 && l < m) if(box[r][c+l] !='+') return false;
    else if(c+l==m ) if(box[r][c-1]!='+') return false;
    else
    {
        if((c-1>=0 && box[r][c-1]!='+') || (c+l < m && box[r][c+l]!='+') ) return false;
    }
    

    for (int i = 0; i < word.length(); i++)
    {
        if (c + i >= box[0].size())
            return false;

        if (box[r][c + i] != '-' && box[r][c + i] != word[i])
            return false;
    }

    return true;
}

int placeWordH(int r, int c, string word)
{
    // vector<bool> loc(word.length(), false);
    int loc = 0;
    for (int i = 0; i < word.length(); i++)
    {
        if (box[r][c + i] == '-')
        {
            box[r][c + i] = word[i];
            loc |= 1 << i;
        }
    }
    return loc;
}

void unplaceWordH(int r, int c, string word, int loc)
{
    for (int i = 0; i < word.length(); i++)
    {
        if ((loc & (1 << i)) != 0)
            box[r][c + i] = '-';
    }
}

bool canPlaceWordV(int r, int c, string word)
{
    int l = word.length();
    int n = box.size();

    if(r==0 && l < n) if(box[r+l][c] !='+') return false;
    else if(r+l==n) if(box[r-1][c]!='+') return false;
    else
    {
        if((r-1>=0 && box[r-1][c]!='+') || (r+l < n && box[r+1][c]!='+') ) return false;
    }
    

    for (int i = 0; i < word.length(); i++)
    {
        if (r + i >= box.size())
            return false;

        if (box[r + i][c] != '-' && box[r + i][c] != word[i])
            return false;
    }
    return true;
}

int placeWordV(int r, int c, string word)
{
    // vector<bool> loc(word.length(), false);
    int loc = 0;
    for (int i = 0; i < word.length(); i++)
    {
        if (box[r + i][c] == '-')
        {
            box[r + i][c] = word[i];
            loc |= 1 << i;
        }
    }
    return loc;
}

void unplaceWordV(int r, int c, string word, int loc)
{
    for (int i = 0; i < word.length(); i++)
    {
        if ((loc & (1 << i)) != 0)
            box[r + i][c] = '-';
    }
}

bool crossWord(vector<string> &words, int idx)
{
    if (idx == words.size())
    {
        return true;
    }

    string word = words[idx];
    int count = 0;
    for (int i = 0; i < box.size(); i++)
    {
        for (int j = 0; j < box[0].size(); j++)
        {

            if (box[i][j] == '-' || box[i][j] == word[0])
            {
                if (canPlaceWordH(i, j, word))
                {
                    int loc = placeWordH(i, j, word);
                    if (crossWord(words, idx + 1))
                        return true;
                    unplaceWordH(i, j, word, loc);
                }

                if (canPlaceWordV(i, j, word))
                {
                    int loc = placeWordV(i, j, word);
                    if (crossWord(words, idx + 1))
                        return true;
                    unplaceWordV(i, j, word, loc);
                }
            }
        }
    }

    return false;
}

void crossWord()
{
    vector<string> words = {"agra", "norway", "england", "gwalior"};
    crossWord(words, 0);
    for (int i = 0; i < box.size(); i++)
    {
        for (int j = 0; j < box[0].size(); j++)
        {
            cout << box[i][j] << " ";
        }
        cout << endl;
    }
}

void solve()
{
    // pathSet();
    // sudoku();
    // crypto();
    crossWord();
}

int main()
{
    solve();
}