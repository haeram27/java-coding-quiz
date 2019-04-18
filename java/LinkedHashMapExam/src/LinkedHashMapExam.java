import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExam {
    public static void main(String[] args) {

        final int MAP_DEFAULT_ENTRY_SIZE = 16;
        Map<Integer, String> insertOrderLmh = 
                new LinkedHashMap<>(MAP_DEFAULT_ENTRY_SIZE, .75f, false);
        Map<Integer, String> accessOrderLmh = 
                new LinkedHashMap<>(MAP_DEFAULT_ENTRY_SIZE, .75f, true);
        
        String accessCheck;

        insertOrderLmh.put(1, "a");
        insertOrderLmh.put(3, "c");
        insertOrderLmh.put(2, "b");
        accessCheck = insertOrderLmh.get(3);

        accessOrderLmh.put(1, "a");
        accessOrderLmh.put(3, "c");
        accessOrderLmh.put(2, "b");
        accessCheck = accessOrderLmh.get(3);

        System.out.println("insertOrder: " + insertOrderLmh);
        System.out.println("accessOrder: " + accessOrderLmh);

        final int MAP_TEST_ENTRY_SIZE = 4;
        @SuppressWarnings("serial")
        Map<Integer, String> lhm = 
                new LinkedHashMap<Integer, String>(MAP_TEST_ENTRY_SIZE, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > MAP_TEST_ENTRY_SIZE;
            }
        };
        
        lhm.put(0, "H");
        lhm.put(1, "E");
        lhm.put(2, "L");
        lhm.put(3, "L");
        lhm.put(4, "O");
        System.out.println(
                "\n[InsertionOrder + removeEldestEntry ON TEST]: " + "\n" + lhm);

        lhm.clear();
        lhm.put(0, "H");
        lhm.put(1, "E");
        lhm.put(2, "L");
        lhm.put(3, "L");
        System.out.println("\n[Access(Get) 0 index]:" + lhm.get(0));
        lhm.put(4, "O");
        System.out.println(
                "[AccessOrder + removeEldestEntry ON TEST]: " + "\n" + lhm);
    }
}
