#include <iostream>
#include <vector>

using namespace std;

void print(vector<int> &arr)
{
    for (int ele : arr)
    {
        cout << ele << " ";
    }
    cout << endl;
}

void print2D(vector<vector<int>> &arr)
{
    for (vector<int> ar : arr)
    {
        print(ar);
    }
    cout << endl;
}

//Two Pointer Type.========================================================

int fib01(int n, vector<int> &dp)
{
    if (n <= 1)
        return dp[n] = n;

    if (dp[n] != 0)
        return dp[n];

    int a = fib01(n - 1, dp);
    int b = fib01(n - 2, dp);

    return dp[n] = a + b;
}

int fib01_DP(int N, vector<int> &dp)
{
    for (int n = 0; n <= N; n++)
    {
        if (n <= 1)
        {
            dp[n] = n;
            continue;
        }

        int a = dp[n - 1]; //fib01(n - 1, dp);
        int b = dp[n - 2]; //fib01(n - 2, dp);

        dp[n] = a + b;
    }

    return dp[N];
}

int fib01_opti(int N)
{
    int a = 0, b = 1;
    for (int n = 2; n <= N; n++)
    {
        int sum = a + b;
        a = b;
        b = sum;
    }

    return b;
}

void fibo()
{
    int n = 7;
    vector<int> dp(n + 1, 0);
    cout << fib01(n, dp) << endl;
    // cout << fib01_DP(n, dp) << endl;
    // cout << fib01_opti(n) << endl;

    print(dp);
}
int main(){
    fibo();
}