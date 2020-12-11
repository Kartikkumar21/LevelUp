 //https://practice.geeksforgeeks.org/problems/boolean-parenthesization/0#
    public static void main (String[] args) throws IOException 
    {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader((System.in))));
        //  Scanner scn = new Scanner( System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            scn.nextLine();
            String str = scn.nextLine();
            
            int N = str.length();
            pair_[][] dp = new pair_[N][N];
            System.out.println(booleanParen(str,0,N - 1,dp).TCount % mod);
        }
    
    }
    
        public static class pair_{
       int TCount = 0;
       int FCount = 0;

       pair_(int T,int F){
           this.TCount = T;
           this.FCount = F;
       }
   }
   
   static int mod = 1003;
   public static void EvaluateBooleanAns(pair_ leftAns, pair_ rightAns,char oper,pair_ ans){
        int totalWays =  ( (leftAns.TCount % mod + leftAns.FCount % mod) % mod * (rightAns.TCount % mod + rightAns.FCount % mod) % mod ) % mod;
        if(oper == '|'){
           
           int fcount = (leftAns.FCount % mod * rightAns.FCount % mod) % mod;
           ans.TCount += (totalWays % mod - fcount  % mod + mod) % mod;
           ans.FCount += fcount;

       }else if(oper == '&'){
           
           int tcount = (leftAns.TCount % mod * rightAns.TCount % mod) % mod;
           ans.TCount += tcount;
           ans.FCount += (totalWays % mod - tcount  % mod + mod) % mod;
      
       }else{
           
           int tcount = ( (leftAns.TCount % mod * rightAns.FCount % mod) % mod + (leftAns.FCount % mod * rightAns.TCount % mod) % mod) % mod;
           ans.TCount += tcount;
           ans.FCount += (totalWays % mod - tcount  % mod + mod) % mod;
       
       }


   }

   public static pair_ booleanParen(String str,int si,int ei,pair_[][] dp){
       if(si == ei){
           int t = str.charAt(si) == 'T' ? 1 : 0;
           int f = str.charAt(si) == 'F' ? 1 : 0;
           pair_ base = new pair_(t,f);
           return dp[si][ei] = base;
       }

       if(dp[si][ei] != null) return dp[si][ei];

       pair_ ans = new pair_(0,0);
       for(int cut = si + 1;cut < ei; cut+=2){
           pair_ leftAns = booleanParen(str,si,cut-1,dp);
           pair_ rightAns = booleanParen(str,cut+1,ei,dp);

           char oper = str.charAt(cut);
           EvaluateBooleanAns(leftAns,rightAns,oper,ans);
       }

       return dp[si][ei] = ans;
   }