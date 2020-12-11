class suduko{
vector<vector<int>> board =
    {{3, 0, 0, 0, 0, 0, 0, 0, 0},
     {5, 2, 0, 0, 0, 0, 0, 0, 0},
     {0, 8, 7, 0, 0, 0, 0, 3, 1},
     {0, 0, 3, 0, 1, 0, 0, 8, 0},
     {9, 0, 0, 8, 6, 3, 0, 0, 5},
     {0, 5, 0, 0, 9, 0, 6, 0, 0},
     {1, 3, 0, 0, 0, 0, 2, 5, 0},
     {0, 0, 0, 0, 0, 0, 0, 7, 4},
     {0, 0, 5, 2, 0, 6, 3, 0, 0}};

void print2D()
{
    for (vector<int> &a : board)
    {
        for (int ele : a)
        {
            cout << ele << " ";
        }
        cout << endl;
    }
}

bool isSafeToPlaceNumber(int r, int c, int num)
{
    //Row
    for (int i = 0; i < 9; i++)
    {
        if (board[i][c] == num)
            return false;
    }

    //Col
    for (int i = 0; i < 9; i++)
    {
        if (board[r][i] == num)
            return false;
    }

    //Mat
    r = (r / 3) * 3;
    c = (c / 3) * 3;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (board[r + i][c + j] == num)
                return false;
        }
    }

    return true;
}

int sudokuSolver(int vidx, vector<int> &loc)
{
    if (vidx == loc.size())
    {
        print2D();
        return 1;
    }

    int idx = loc[vidx];
    int r = idx / 9;
    int c = idx % 9;

    int count = 0;
    for (int num = 1; num <= 9; num++)
    {
        if (isSafeToPlaceNumber(r, c, num))
        {
            board[r][c] = num;
            count += sudokuSolver(vidx + 1, loc);
            board[r][c] = 0;
        }
    }

    return false;
}
void sudoku()
{
    vector<int> loc;
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            if (board[i][j] == 0)
            {
                loc.push_back(i * 9 + j);
            }
            else
            {
                int mask = 1 << board[i][j];
                rowA[i] ^= mask;
                colA[j] ^= mask;
                matA[i / 3][j / 3] ^= mask;
            }
        }
    }

    sudokuSolver(0, loc);
    // sudokuSolver_Best(0, loc);
}
void solve()
{
    // pathSet();
    sudoku();
    // crypto();
    // crossWord();
}

int main()
{
    solve();
}
}