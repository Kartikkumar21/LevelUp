import java.util.HashMap;
import java.util.HashSet;
class hashmap{
    public static void hashfreq(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        // for(int i=0; i < str.length(); i++){
        //     char ch = str.charAt(i);
        //     if(map.containsKey(ch))
        //        map.put(ch,map.get(ch) + 1);
        //     else map.put(ch , 1);
        // }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.print(map.get("@"));
        for(Character ch:map.keySet()){
            System.out.println(map.get(ch));
        }
        System.out.print(map);
    }
    public static void main(String[] args){
        String str="aaaaabbbbcccdde111223";
        hashfreq(str);
    }
}