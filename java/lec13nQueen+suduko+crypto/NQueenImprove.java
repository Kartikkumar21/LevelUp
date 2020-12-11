import java.util.*;
class NQueenImprove{
    static boolean[] rowA,colA,diagA,adiagA;
    static int call=0;
    public static int queen(int n,int r,int tnq,String ans){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }
        call++;
        int count=0;
        for(int c=0;c<n;c++){
            if(!colA[c] && !diagA[r+c] && !adiagA[r-c+n-1]){
                colA[c]= !colA[c];
                diagA[r+c]= !diagA[r+c];
                adiagA[r-c+n-1]= !adiagA[r-c+n-1];

                count+=queen(n,r+1,tnq-1,ans+"("+r+","+c+")");

                colA[c]= !colA[c];
                diagA[r+c]= !diagA[r+c];
                adiagA[r-c+n-1]= !adiagA[r-c+n-1];
            }
        }
        return count;
    }
    public static void main(String[] args){
        boolean[][] box = new boolean[4][4];
      int tnq = 4;
      int n = box.length;
      int m = box[0].length;
      rowA = new boolean[n];
      colA = new boolean[m];
      diagA = new boolean[n+m-1];
      adiagA = new boolean[n+m-1];
      System.out.println(queen(n,0,tnq,""));
      System.out.println(call);
    }
}