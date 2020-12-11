 // ls = left palindrome string,rs = right palindrome string
     public static void generateString(int[][] dp,String s,int i,int j,LinkedList<Character> ls,LinkedList<Character> rs){
        if(i > j || i == j){
            if(i==j){
                ls.addLast(s.charAt(i));
            }

            System.out.print(ls);
            System.out.print(rs);
            System.out.println();
            
            if(i==j){
                ls.removeLast();
            }
 
            return;
        }

        if(s.charAt(i) == s.charAt(j)){            
            ls.addLast(s.charAt(i));
            rs.addFirst(s.charAt(i));

            generateString(dp,s,i+1,j-1,ls,rs);

            ls.removeLast();
            rs.removeFirst();
        } 
        else{

            if(dp[i+1][j] > dp[i][j-1]) generateString(dp,s,i+1,j,ls,rs);
            else if(dp[i+1][j] < dp[i][j-1]) generateString(dp,s,i,j-1,ls,rs);
            else{
                generateString(dp,s,i,j-1,ls,rs);
                generateString(dp,s,i+1,j,ls,rs);
            }
        }
    }

    public static void generateString(int[][] dp,String s,int i,int j,String ls,String rs){
        if(i > j || i == j){
            if(i==j){
                ls += s.charAt(i);
            }
            System.out.println(ls + rs);
            return;
        }

        if(s.charAt(i) == s.charAt(j)){            
            generateString(dp,s,i+1,j-1,ls + s.charAt(i),s.charAt(i) + rs);
        } 
        else{
            if(dp[i+1][j] > dp[i][j-1]) generateString(dp,s,i+1,j,ls,rs);
            else if(dp[i+1][j] < dp[i][j-1]) generateString(dp,s,i,j-1,ls,rs);
            // else{
            //     generateString(dp,s,i,j-1,ls,rs);
            //     generateString(dp,s,i+1,j,ls,rs);
            // }
        }
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // int ans = longestPalindromeSubseq(s,0,n-1,dp);
        int ans = longestPalindromeSubseqDP(s,0,n-1,dp);

        return ans;
    }