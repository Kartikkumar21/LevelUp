class sudokuSolver_Best{
    int rowA[9] = {0};
int colA[9] = {0};
int matA[3][3] = {0};
    int sudokuSolver_Best(int vidx, vector<int> &loc)
    
{
    if (vidx == loc.size())
    {
        print2D();
        return 1;
    }

    int idx = loc[vidx];
    int i = idx / 9;
    int j = idx % 9;

    int count = 0;
    for (int num = 1; num <= 9; num++)
    {
        int mask = 1 << num;
        if ((rowA[i] & mask) == 0 && (colA[j] & mask) == 0 && (matA[i / 3][j / 3] & mask) == 0)
        {
            rowA[i] ^= mask;
            colA[j] ^= mask;
            matA[i / 3][j / 3] ^= mask;
            board[i][j] = num;

            count += sudokuSolver_Best(vidx + 1, loc);

            board[i][j] = 0;
            rowA[i] ^= mask;
            colA[j] ^= mask;
            matA[i / 3][j / 3] ^= mask;
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

    // sudokuSolver(0, loc);
    sudokuSolver_Best(0, loc);
}

}