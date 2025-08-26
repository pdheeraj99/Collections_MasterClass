import java.util.HashMap;
import java.util.Map;

/**
 * This file demonstrates the basic usage of HashMap.
 * Note: The class is not public to avoid conflict with java.util.HashMap.
 * Ee file HashMap యొక్క basic usage ni chupistundi.
 * Class peru public kaadu, endukante java.util.HashMap tho conflict avvakunda undataniki.
 */
class HashMapDemo {
    public static void main(String[] args) {
        // Create a Map using HashMap
        // Key is student's roll number (Integer), Value is student's name (String)
        Map<Integer, String> studentMap = new HashMap<>();

        // Add key-value pairs (entries)
        studentMap.put(101, "Rahul");
        studentMap.put(102, "Priya");
        studentMap.put(103, "Suresh");
        System.out.println("Student Map: " + studentMap);

        // Get a value using its key
        String student102 = studentMap.get(102);
        System.out.println("Student with roll number 102 is: " + student102);

        // Check if a key exists
        boolean hasKey104 = studentMap.containsKey(104);
        System.out.println("Does map contain roll number 104? " + hasKey104);

        // Remove an entry
        studentMap.remove(101);
        System.out.println("After removing roll number 101: " + studentMap);

        // Iterate over the map
        System.out.println("\nIterating over the map:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
