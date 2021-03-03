package student;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static boolean LLTEST1 = false;
    static boolean LLTEST2 = false;
    static boolean LLTEST3 = false;
    static boolean LLTEST4 = true;

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
            LinkedListDS<Integer> testThree = new LinkedListDS<Integer>();
            testThree.add(0,1);
            System.out.println("Getting the size: " + testThree.size());
        }

        if (LLTEST4){
            MapDS<Integer, String> testOne = new MapDS<Integer, String>();
            testOne.put(0,"Bruno");
            System.out.println("Getting the size: " + testOne.size());
        }
    }
}
