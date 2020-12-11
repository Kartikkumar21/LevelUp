import java.util.*;
class Nqueen{
   public static boolean isSafeToPlaceQueen(boolean[][] box,int r,int c){

    // int[][] dirA = {{0,-1},{-1,0},{-1,-1},{-1,1}};
      int[][] dirA = {{0,-1},{-1,0},{-1,-1},{-1,1},{0,1},{1,0},{1,1},{1,-1}};
    
      for(int d = 0; d < dirA.length;d++){
        for(int rad = 1 ; rad<=box.length;rad++){
          int x = r + rad*dirA[d][0];
          int y = c + rad*dirA[d][1];

          if(x >= 0 && y >= 0 && x < box.length && y < box[0].length){
            if(box[x][y]) return false;
          }else break;
        }
      }
      return true;
    }

    // combination

    public static int Nqueencomb(boolean[][] box,int idx,int tnq,int qpsf,String ans){
        if(qpsf==tnq){
            System.out.println(ans+" ");
            return 1;
        }
        int count=0;
        int n=box.length;
        for(int i=idx;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            if(isSafeToPlaceQueen(box, r, c)){
            box[r][c]=true;
            count+=Nqueencomb(box,i+1,tnq,qpsf+1,ans+" ("+r + ","+ c+")");
             box[r][c]=false;
            }
        }
        return count;
    }

    // permutation

    public static int Nqueen_02(boolean[][] box,int qpsf,int tnq,String ans){
      if(qpsf == tnq){
        System.out.println(ans);
        return 1;
      }
      int count=0;
      int n = box.length;
      for(int i = 0 ; i < n*n; i++){
        int r = i / n;
        int c = i % n;
        
        if(!box[r][c] && isSafeToPlaceQueen(box, r, c)){
          box[r][c] = true;
          count+=Nqueen_02(box,qpsf+1,tnq,ans +"("+ r + ","+c + ") ");
          box[r][c] = false;  
        }
      }
      return count;
    }
    // nQueen improvised
    static boolean[] rowA,colA,diagA,adiagA;
    public static int Nqueen_03(int n,int idx,int qpsf,int tnq,String ans){
      if(qpsf == tnq){
        System.out.println(ans);
        return 1;
      }
      int count=0;
      // calls++;
      for(int i = idx ; i < n*n; i++){
        int r = i / n;
        int c = i % n;
        
        if(!rowA[r] && !colA[c] && !diagA[r+c] && !adiagA[r-c+n-1]){

          rowA[r] = !rowA[r];
          colA[c] = !colA[c];
          diagA[r+c] = !diagA[r+c];
          adiagA[r-c+n-1] = !adiagA[r-c+n-1];

          count+=Nqueen_03(n,i + 1,qpsf+1,tnq,ans +"("+ r + ","+c + ") ");

          rowA[r] = !rowA[r];
          colA[c] = !colA[c];
          diagA[r+c] = !diagA[r+c];
          adiagA[r-c+n-1] = !adiagA[r-c+n-1];

        }
      }
      return count;
    }
    public static void main(String[] args){
        boolean[][] box=new boolean[10][10];
        int n = box.length;
      int m = box[0].length;
      rowA = new boolean[n];
      colA = new boolean[m];
      diagA = new boolean[n+m-1];
      adiagA = new boolean[n+m-1];
      System.out.println(Nqueen_03(n,0,0,10,""));
        // System.out.print(Nqueencomb(box,0,4,0,""));
        // System.out.print(Nqueen_02(box,0,4,""));
    }
}
