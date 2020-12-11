// leetcode 
public void swap(int[] arr, int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
public void reverse(int[] arr,int i,int j){
    while(i<j){
        swap(arr,i++,j--);
    }
}

public void rotate(int[] arr,int k){
    if(arr.length==0) return;

    k=(k%n+n)%n;

    int n=arr.length;
    reverse(arr,0,n-1);
    reverse(arr,0,k-1);
    reverse(arr,k,n-1);
} 