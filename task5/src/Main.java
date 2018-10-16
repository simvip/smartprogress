import java.util.*;

/**
 * Created by Ivan Sliusar on 28.09.2018.
 * Red Line Soft corp.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Realize by HashMap " + CompareWordsByCountElementByMap("mama", "mmaa"));
        System.out.println("Realize by ArrayList " + CompareWordsByArrayList("mama", "mmaa"));
        System.out.println("Realize by LinkedList " + compareWordsByLinkedList("mama", "mmaa"));
    }

    /**
     * Return true if amount letters in first equal amount letters in second words.
     * @param first String
     * @param second String
     * @return boolean
     */
    public static boolean CompareWordsByCountElementByMap(String first, String second) {
        if (first.length() != second.length()) return false;
        String[] splitFirst = first.split("");
        Map<String, Integer> map = new HashMap<>();
        int newValue;
        for (String key :
                splitFirst) {
            newValue = 1;
            if (map.containsKey(key)) {
                newValue = map.get(key) + 1;
            }
            map.put(key, newValue);
        }

        String[] splitSecond = second.split("");
        for (String key :
                splitSecond) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) < 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if amount letters in first equal amount letters in second words.
     * @param first String
     * @param second String
     * @return boolean
     */
    public static boolean compareWordsByLinkedList(String first, String second){
        if (first.length() != second.length()) return false;
        ArrayList<String> firstList  = new ArrayList<>(Arrays.asList(first.split("")));
        LinkedList<String> secondList = new LinkedList<>(Arrays.asList(second.split("")));
        for (int i = 0; i < firstList.size(); i++) {
            secondList.remove(firstList.get(i));
        }
        return secondList.size()==0;
    }

    /**
     * Return true if amount letters in first equal amount letters in second words.
     * @param first String
     * @param second String
     * @return boolean
     */
    public static boolean CompareWordsByArrayList(String first, String second){

        if (first.length() != second.length()) return false;
        ArrayList<String> firstList  = new ArrayList<>(Arrays.asList(first.split("")));
        Collections.sort(firstList);

        ArrayList<String> secondList = new ArrayList<>(Arrays.asList(second.split("")));
        Collections.sort(secondList);

        for (int i = 0; i < firstList.size(); i++) {
            if (!firstList.get(i).equals(secondList.get(i))) return false;
        }
        return true;
    }
}
