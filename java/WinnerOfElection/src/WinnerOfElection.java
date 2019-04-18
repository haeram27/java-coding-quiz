import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class WinnerOfElection {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] votes = new String[10];
        votes[0] = "a";
        votes[1] = "m";
        votes[2] = "h";
        votes[3] = "d";
        votes[4] = "m";
        votes[5] = "v";
        votes[6] = "h";
        votes[7] = "a";
        votes[8] = "m";
        votes[9] = "m";
        
        
        Map<String, Integer> candidates = new HashMap<String, Integer>();   
        
        for (String tmp : votes) {
            if (candidates.containsKey(tmp)) {
                Integer count = candidates.get(tmp);
                candidates.put(tmp, ++count);
            } else {
                candidates.put(tmp, Integer.valueOf(1));
            }
        }
        
//        candidates.forEach((k,v)->
//        System.out.println("Key : " + k + " Value : " + v));
        
        List<Entry<String, Integer>> list = 
                new ArrayList<Entry<String, Integer>>(candidates.entrySet());
        
        // sort by descending order
        list.sort(Collections.reverseOrder(Entry.comparingByValue())); 
        
//        list.forEach(e->
//        System.out.println("Key : " + e.getKey() + " Value : " + e.getValue()));
        
        System.out.println("The winner is "+ list.get(0).getKey());
    }
}