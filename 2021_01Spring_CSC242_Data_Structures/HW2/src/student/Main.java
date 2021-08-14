package student;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static boolean LLTEST1 = false;
    static boolean LLTEST2 = false;
    static boolean LLTEST3 = false;
    static boolean LLTEST4 = false;

    static boolean HMTEST1 = true;

    public static void main(String[] args) {
        if (LLTEST1){
            LinkedListDS<Integer> testOne = new LinkedListDS<Integer>();
            System.out.println("Getting the size: " + testOne.size());

            testOne.add(1);
            System.out.println("Getting 1st Value: " + testOne.get(0));
            System.out.println("Getting the size: " + testOne.size());


            testOne.add(2);
            System.out.println("Getting 2nd Value: " + testOne.get(1));
            System.out.println("Getting the size: " + testOne.size());

            testOne.add(3);
            System.out.println("Getting 3rd Value: " + testOne.get(2));
            System.out.println("Getting the size: " + testOne.size());

            testOne.add(null);

            System.out.println("Getting Index of value 1 => " + testOne.indexOf(null));


            try {
                System.out.println("Getting 4th Value: " + testOne.get(3));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println(ex);
            }

            System.out.println("Getting the size: " + testOne.size());

            System.out.println("Clearing the Linked List: ");
            testOne.clear();
            System.out.println("Getting the size: " + testOne.size());

            Integer[] list = new Integer[]{1, 2, 3, 4};
            testOne.addAll(0, Arrays.asList(list));
            System.out.println("Getting the size: " + testOne.size());
        }

        if (LLTEST2){
            LinkedListDS<Integer> testTwo = new LinkedListDS<Integer>();
            Integer[] list = new Integer[500];
            System.out.println("Creating list of 500 objects");
            for (int i = 0; i < 500; i++){
                list[i] = i;
            }

            System.out.println("Print values of array");
            for (int i = 0; i < testTwo.size(); i++){
                System.out.println("Value at Node [" + i + "] => " + testTwo.get(i));
            }

            System.out.println("Creating list of 100 objects");
            for (int i = 0; i < 100; i++){
                testTwo.add(i);
                System.out.println("Value of recently created Node [" + i + "] => " + testTwo.getNode(i));
                System.out.println("Value right After creating Node [" + i + "] => " + testTwo.get(i));
            }
            System.out.println("Getting the size: " + testTwo.size());

            System.out.println("Print values of array");
            for (int i = 0; i < testTwo.size(); i++){
                System.out.println("Value at Node [" + i + "] => " + testTwo.get(i));
            }

            System.out.println("Inserting array into Linked List");
            testTwo.addAll(50, Arrays.asList(list));
            System.out.println("Getting the size: " + testTwo.size());


            System.out.println("Print values of array");
            for (int i = 0; i < testTwo.size(); i++){
                System.out.println("Value at Node [" + i + "] => " + testTwo.get(i));
            }

            System.out.println("Testing Contains All with Right characters => "+ testTwo.containsAll(Arrays.asList(list)));

        }

        if (LLTEST3){
            LinkedListDS<String> list = new LinkedListDS<String>();

            // Use add() method to add elements
            // into the List
            list.add("Welcome");
            list.add("To");
            list.add("Geeks");
            list.add("4");
            list.add("Geeks");

            // Displaying the List
            System.out.println("List: " + list);

            // Creating another empty List
            LinkedList<String> listTemp1 = new LinkedList<>();

            listTemp1.add("Geeks");
            listTemp1.add("4");
            listTemp1.add("Geeks");

            System.out.println("Are all the contents equal? "
                    + list.containsAll(listTemp1));

            LinkedList<String> listTemp2 = new LinkedList<>();

            listTemp2.add("Geeks");
            listTemp2.add("4");
            listTemp2.add("Geeks");


            System.out.println("Are all the contents equal? "
                    + list.containsAll(listTemp2));
        }

        if (LLTEST4){
            MapDS<Integer, String> testOne = new MapDS<Integer, String>();
            System.out.println("Is Map empty => " + testOne.isEmpty());

            testOne.put(0,"Bruno");
            System.out.println("Getting the size: " + testOne.size());
            System.out.println("Is Map empty => " + testOne.isEmpty());
        }

        if (HMTEST1){
            Map<Integer, String> one = new HashMap<>();
            System.out.println("JAVA HASHMAP");
            System.out.println("Size of Map is: " + one.size());
            System.out.println("Is Map empty?  " + one.isEmpty());

            one.put(1, "Monday");
            System.out.println("What's at key 1 in HashMap = " + one.get(1));
            one.put(2, "Tuesday");
            one.put(3, "Wednesday");
            one.put(4, "Thursday");
            one.put(5, "Friday");
            one.put(6, "Saturday");
            one.put(7, "Sunday");
            one.put(1, "Extra Day");
            System.out.println("What's at key 1 in HashMap = " + one.get(1));

            MapDS two = new MapDS();
            System.out.println("\nBKO's HASHMAP");
            System.out.println("Size of Map is: " + two.size());
            System.out.println("Is Map empty?  " + two.isEmpty());

            two.put(1,"Monday");
            System.out.println("What's at key 1 in MapDS = " + two.get(1));
            System.out.println("Size of Map is: " + two.size());

            System.out.println("\nPUT ALL Function");
            two.putAll(one);
            System.out.println("Size of Map is: " + two.size());
            System.out.println("Is Map empty?  " + two.isEmpty());
        }
    }
}
