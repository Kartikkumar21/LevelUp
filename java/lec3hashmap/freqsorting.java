import java.util.HashMap;
import java.util.HashSet;
class containsDuplicate{
     public String frequencySort(String str) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->{
            return map.get(b) - map.get(a);
        });

        for(Character ch : map.keySet()){
            pq.add(ch); 
        }

        StringBuilder sb =new StringBuilder();
        while(pq.size() != 0){
            Character ch = pq.remove();
            int freq = map.get(ch);
            for(int i=0;i<freq;i++) sb.append(ch);
        }

        return sb.toString();
    }

}
