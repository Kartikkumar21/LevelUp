// leetcode 75
class Solution {
    public void sortColors(int[] arr){
        if(arr.length==0){
            return;
        }
        int p1=-1 , idx=0, n=arr.length, p2=n-1;
        while(idx<=p2){
            if(arr[idx]==0)
                swap(arr,++p1,idx++);
            else if(arr[idx]==2)
                swap(arr,idx,p2--);
            else idx++;
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}