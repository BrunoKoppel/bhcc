package homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] strArray = {"Hello", "Multiple", "Time", "Before", "Look"};
        int
        List<String> strList = Arrays.asList(strArray.clone());
        long begin = System.currentTimeMillis();
        List random = StreamsHomeWork.sortCharSum(strList);
        long end = System.currentTimeMillis();

        System.out.println("Startx time is = " + begin);
        System.out.println("Ending time is = " + end);
        System.out.println("Time of Execution => " + String.valueOf(end - begin));
        System.out.println("List returned = " + random.toString());

        Stream<Object> streamObj = StreamsHomeWork.getStream(strList);
        System.out.println("Stream object = " + streamObj.toString());
        System.out.println("Stream object = " + StreamsHomeWork.convertStreamToStrings(streamObj).toString());

        Stream<String> streamStr = StreamsHomeWork.getStream(strList);
        System.out.print("Result from toMap" + StreamsHomeWork.toMap(streamStr));
    }
}
