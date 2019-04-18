import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSortExam {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 3);
        map.put("b", 12);
        map.put("c", 54);
        map.put("d", 51);
        map.put("e", 8);

        System.out.println("==== Before Sorting ====");
        map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        System.out.println("");

        sortByValue(map);
    }
    
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(final Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        
        // ascending sort
        list.sort(Entry.comparingByValue()); 
        //Collections.reverse(list); // descending after ascending
        
        // descending sort
        //list.sort(Collections.reverseOrder(Entry.comparingByValue())); 
        

// Print ArrayList
        System.out.println("==== After Sorting ====");
        for (Map.Entry<K, V> entry : list) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        System.out.println("");
        
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

// Print Map using foreach() GOOD
/*
        System.out.println("==== Print Map #1====");
        result.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        System.out.println("");
*/


// Print Map using for loop NORMAL
/*        
        System.out.println("==== Print Map #2====");
        for (Map.Entry<K, V> entry : result.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        System.out.println("");
*/
        return result;
    }
}
