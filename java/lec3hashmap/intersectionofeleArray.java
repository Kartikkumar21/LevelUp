import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
class intersectionofeleArray{
    public static int[] intersection(int[] num1,int[] num2){
        HashSet<Integer> map=new HashSet<>();
        for(int ele:num1){
            map.add(ele);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int ele:num2){
            if(map.contains(ele)){
                ans.add(ele);
                map.remove(ele);
            }
        }
        int[] arr=new int[ans.size()];
        int i=0;
        for(int ele:ans){
            arr[i++]=ele;
        }
        return arr;
    }
    public static void main(String[] args){
        int[] num1={1,2,2,1};
        int[] num2={2,2};
        System.out.print(intersection(num1,num2));
    }
}
