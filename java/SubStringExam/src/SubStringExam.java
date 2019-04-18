import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class SubStringExam {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String qStr = "aabbc";
        int qLen = qStr.length();
        
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        for (int i = 0; i < qLen; ++i) {
            for (int j = i+1; j <= qLen ; ++j) {
                String subStr = qStr.substring(i, j);
                if (lhm.containsKey(subStr)) {
                    int val = lhm.get(subStr);
                    lhm.put(subStr, ++val);
                } else {
                    lhm.put(subStr, 1);
                }
            }
        }

        for (Entry<String, Integer> e : lhm.entrySet()) {
            System.out.println(String.format("%s %d", e.getKey(), e.getValue()));
        }
    }
}