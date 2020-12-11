//Leetcode 973
public class kClosestPair implements Comparable<kClosestPair>{
    int i = 0;
    int j = 0;

    kClosestPair(int i,int j){
        this.i=i;
        this.j=j;
    }

    @Override
    public int compareTo(kClosestPair o){
        int r1 = this.i * this.i + this.j * this.j;
        int r2 = o.i * o.i + o.j * o.j;
        
        return r2 - r1;   // other - this
    }
}

public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<kClosestPair> pq=new PriorityQueue<>();

    for(int[] p: points){
        pq.add(new kClosestPair(p[0],p[1]));
        if(pq.size() > k) pq.remove();
    }

    int[][] ans=new int[K][2];
    
    int i = 0;
    while(pq.size()!=0){
        kClosestPair p = pq.remove();
        ans[i][0] = p.i;
        ans[i][1] = p.j; 
        i++;
    }

    return ans;
}