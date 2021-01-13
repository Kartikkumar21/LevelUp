import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
class freqmappos{
    public static void freqmap_pos(String str){
      HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.putIfAbsent(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        for(Character ch: map.keySet()){
            System.out.println(ch+"->"+map.get(ch));
        }
    }
    public static void main(String[] args){
        String str="aaaaabbbcccse2342343";
        freqmap_pos(str);
    }
}