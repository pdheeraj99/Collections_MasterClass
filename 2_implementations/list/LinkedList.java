import java.util.LinkedList;

/**
 * This file demonstrates the basic usage of LinkedList.
 * Note: The class is not public to avoid conflict with java.util.LinkedList.
 * Ee file LinkedList యొక్క basic usage ni chupistundi.
 * Class peru public kaadu, endukante java.util.LinkedList tho conflict avvakunda undataniki.
 */
class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> animals = new LinkedList<>();
        System.out.println("Created an empty LinkedList: " + animals);

        // Add elements
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Elephant");
        System.out.println("After adding elements: " + animals);

        // LinkedList has special methods like addFirst and addLast
        animals.addFirst("Cheetah");
        animals.addLast("Giraffe");
        System.out.println("After using addFirst and addLast: " + animals);

        // Get the first and last elements
        System.out.println("First animal (peekFirst): " + animals.peekFirst());
        System.out.println("Last animal (peekLast): " + animals.peekLast());

        // Remove the first and last elements
        animals.removeFirst();
        animals.removeLast();
        System.out.println("After removing the first and last elements: " + animals);
    }
}
