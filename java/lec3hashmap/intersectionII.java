import java.util.*;
class intersection{
    public static int[] inter(int[] num1,int[] num2){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:num1){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int ele:num2){
            if(map.containsKey(ele)){
                ans.add(ele);
                map.put(ele,map.get(ele)-1);
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
        System.out.print(inter(num1,num2));
    }
}