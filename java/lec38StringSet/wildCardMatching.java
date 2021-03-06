// Leetcode 44
    public int isMatch(String s, String p,int n,int m,int[][] dp) {
        if(n == 0 || m == 0){
            if(n==0 && m == 0) return dp[n][m] = 1;
            else if(m == 1 && p.charAt(m-1) == '*') return dp[n][m] = 1;
            return dp[n][m]  = 0;
        }

        if(dp[n][m] != -1) return dp[n][m];

        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);
        int val = -1;
        if(ch1 == ch2 || ch2 == '?')  val = isMatch(s,p,n-1,m-1,dp);
        else if(ch2 == '*'){
            boolean res = false;
            res = res || (isMatch(s,p,n,m-1,dp) == 1);
            res = res || (isMatch(s,p,n-1,m,dp) == 1);

            val = res ? 1: 0;
        }else val = 0;

        return dp[n][m] = val;
    }

    public static String removeStar(String str){
        if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(0));
        int i = 1;
        while(i < str.length()){
            while(i < str.length() && str.charAt(i - 1) == '*'&& str.charAt(i) == '*') i++;
            
            if(i < str.length()) sb.append(str.charAt(i));
            i++;
        }

        return sb.toString();
    }

    public boolean isMatch(String s, String p) {
        p = removeStar(p);
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int[] d: dp) Arrays.fill(d,-1);

        return isMatch(s,p,n,m,dp) == 1;
    }