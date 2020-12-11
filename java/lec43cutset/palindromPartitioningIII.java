// leetcode 1278
public int palindromePartition(int si,int ei,int k,int[][] dp,int[][] pdp){
    if(k == 0) return dp[k][ei] = 0;
    if(k == 1) return dp[k][ei] = pdp[si][ei];
    if(ei - si + 1 <= k) return dp[k][ei] = (ei-si+1 < k) ? (int)1e8 : 0;
    
    if(dp[k][ei] != -1) return dp[k][ei];
    
    int min_ = (int)1e8; 
    for(int cut = si; cut < ei;cut++){
        int recAns = palindromePartition(si,cut,k-1,dp,pdp);
        
        min_ = Math.min(min_, pdp[cut + 1][ei] + recAns);
    }
    
    return dp[k][ei] = min_;
}

public int palindromePartition(String str, int k) {
    if(str.length() == 0 || k == 0 || str.length() <= k) return 0;
    int n = str.length();
    int[][] pdp = new int[n][n];
    
    for(int gap = 1;gap<n;gap++){
        for(int i=0,j=gap;j<n;i++,j++){
            pdp[i][j] = pdp[i+1][j-1];
            if(str.charAt(i) != str.charAt(j)) pdp[i][j]++;
        }
    }
    
    int[][] dp = new int[k + 1][n + 1];
    for(int[] d: dp) Arrays.fill(d,-1);
    
    return palindromePartition(0,n-1,k,dp,pdp);
    
}
