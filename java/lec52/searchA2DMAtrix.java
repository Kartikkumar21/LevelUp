// leetcode 74
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int si=0;
        int ei= (n * m )-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            int val=matrix[mid/m][mid%m];
            
            if(val==target) return true;
            else if(val< target) si=mid+1;
            else ei = mid-1;
        }
        return false;
    }
}