// leetcode 930
// method 1


// method 2
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n=A.length;
        if(n==0) return 0;
        int si=0,  ei=0,  count=0,  psum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);        
        while(ei<n){
            psum += A[ei++];
            count += map.getOrDefault(psum-S,0);
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return count;
    }
}

// method 3
class Solution {
    public int numSubarraysWithAtmostSum(int[] A, int k) {
        int n=A.length;
        int si=0,ei=0,psum=0,count=0;
        int[] freq=new int[30000+1];
        while(ei<n){
            psum+=A[ei++];
            while(psum>k){
                psum-= A[si++];
            }
            count += ei - si;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] A, int k) {
            if(A.length==0) return 0;
        int n=A.length;
        return numSubarraysWithAtmostSum(A,k)-(k!=0 ? numSubarraysWithAtmostSum(A,k-1):0);

    }
}