// leetcode 1074
class Solution {
    public int numSubmatrixSumTarget(int[][] arr, int k) {
    int n=arr.length; 
    int m=arr[0].length;
    for(int i=1;i<n;i++){
        for(int j=0;j<m;j++){
            arr[i][j]+=arr[i-1][j];
        }
    }
    int count=0;
    for(int base=0;base<n;base++){
        for(int row=base;row<n;row++){
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=arr[row][j]-(base!=0 ? arr[base-1][j]:0);
                count+=map.getOrDefault(sum-k,0);
                map.put(sum,map.getOrDefault(sum,0)+1);
                
            }
        }
    }
    return count;
}
}