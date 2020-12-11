import java.util.HashSet;
import java.util.ArrayList;
class longestconSeq{
    public static int seq(int[] nums){
        HashSet<Integer> map=new HashSet<>();
        for(int ele:nums){
            map.add(ele);
        }
        int len=0;

        for(int ele:nums){
            if(!map.contains(ele)){
                continue;
            }
            map.remove(ele);
            int pre=ele-1;
            int nex=ele+1;
            while(map.contains(pre)){
                map.remove(pre);
                pre--;
            }
            while(map.contains(nex)){
                map.remove(nex);
                nex--;
            }
            len=Math.max(len,nex-pre-1);
        }
        return len;
    }
    public static void main(String[] args){
        int[] nums={100, 4, 200, 1, 3, 2};
        System.out.print(seq(nums));
    }
}