class crypto{
    string s1 = "send";
string s2 = "more";
string s3 = "money";
vector<int> mapping(26, -1);
int numUsed = 0;

int stringToNumber(string str)
{
    int res = 0;
    for (int i = 0; i < str.length(); i++)
    {
        res = res * 10 + mapping[str[i] - 'a'];
    }

    return res;
}

int cryptoSolver(string str, int idx)
{
    if (idx == str.length())
    {
        int x = stringToNumber(s1);
        int y = stringToNumber(s2);
        int z = stringToNumber(s3);

        if (x + y == z)
        {
            cout << " " << x << "\n+" << y << "\n------\n"
                 << z << endl;
            cout << endl;
            return 1;
        }
        return 0;
    }

    char ch = str[idx];
    int count = 0;
    for (int num = 0; num <= 9; num++)
    {
        int mask = 1 << num;
        if ((numUsed & mask) == 0)
        {
            numUsed ^= mask;
            mapping[ch - 'a'] = num;

            count += cryptoSolver(str, idx + 1);

            numUsed ^= mask;
            mapping[ch - 'a'] = -1;
        }
    }

    return count;
}

void crypto()
{
    string str = s1 + s2 + s3;
    int freq = 0;
    for (char ch : str)
    {
        int mask = 1 << (ch - 'a');
        freq |= mask;
    }

    str = "";
    for (int i = 0; i < 26; i++)
    {
        int mask = 1 << i;
        if ((freq & mask) != 0)
            str += string(1, (char)(i + 'a'));
    }

    // cout << str << endl;
    System.out.print cryptoSolver(str, 0) << endl;
}

void solve()
{
    // pathSet();
    // sudoku();
    crypto();
    // crossWord();
}

int main()
{
    solve();
}
}