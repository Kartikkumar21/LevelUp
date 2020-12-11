class isValidSudu{
int rowA[9] = {0};
int colA[9] = {0};
int matA[3][3] = {0};

//Leetcode 36
bool isValidSudoku(vector<vector<char>> &board)
{
    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            if (board[i][j] != '.')
            {
                int mask = 1 << (board[i][j] - '0');
                if ((rowA[i] & mask) == 0 && (colA[j] & mask) == 0 && (matA[i / 3][j / 3] & mask) == 0)
                {
                    rowA[i] ^= mask;
                    colA[j] ^= mask;
                    matA[i / 3][j / 3] ^= mask;
                }
                else
                    return false;
            }
        }
    }

    return true;
}
}