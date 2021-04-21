package homework;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] strArray = {"Hello", "Multiple", "Time", "Before", "Look", "yes", "about",
                "above", "accept", "according", "account", "across", "act", "action", "activity", "actually",
                "add", "address", "administration", "admit", "adult", "affect", "after", "again", "against",
                "age", "agency", "agent", "ago"};
        String[] listExpected = {"Hello", "Multiple", "Time", "Before", "Look"};
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4, 1, 3);
        List<Integer> list3 = Arrays.asList(5, 3, 3);
        List<Integer> list4 = Arrays.asList(5, 6, 3);
        List<Integer> filterList = Arrays.asList(45, 2, 3);


        List<String> strList = Arrays.asList(strArray.clone());
        long begin = System.currentTimeMillis();
        List random = StreamsHomeWork.sortCharSum(strList);
        long end = System.currentTimeMillis();

//        System.out.println("Startx time is = " + begin);
//        System.out.println("Ending time is = " + end);
//        System.out.println("Time of Execution => " + String.valueOf(end - begin));
//        System.out.println("List returned = " + random.toString());
//
//        Stream<Object> streamObj = StreamsHomeWork.getStream(strList);
//        System.out.println("Stream object = " + streamObj.toString());
//        System.out.println("Stream object = " + StreamsHomeWork.convertStreamToStrings(streamObj).toString());

        Stream<String> streamStr = StreamsHomeWork.getStream(strList);
//        System.out.println("Result from toMap" + StreamsHomeWork.toMap(streamStr));
//        List<List<Integer>> listOfList = Arrays.asList(list1, list2, list3, list4);
//        Object[] SetInt = StreamsHomeWork.flatFilteredMap(filterList,listOfList.stream()).toArray();
//        System.out.print("Result from FlatMap [");
//        for(int i = 0; i < SetInt.length; i++){
//            if (i != SetInt.length - 1)
//                System.out.print(SetInt[i]+",");
//            else
//                System.out.print(SetInt[i]);
//        }
//        System.out.print("]");

        begin = System.currentTimeMillis();
        String output = StreamsHomeWork.findWinners("", 0,false, streamStr).toString();
        end = System.currentTimeMillis();
        System.out.println("Result from findWinners => " + output);
        System.out.println("Startx time is = " + begin);
        System.out.println("Ending time is = " + end);
        System.out.println("Time of Execution => " + String.valueOf(end - begin));

    }
}
