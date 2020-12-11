import java.util.*;
class segregatePosNeg{
    public static void sep(int[] arr){
        if(arr.length==0){
            return;
        }
        int piviot=-1;
        int idx=0;
        int n=arr.length;
        while(idx<n){
            if(arr[idx]>=0){
                swap(arr[++piviot],arr[idx]);
            }
            idx++;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(){

    }
}