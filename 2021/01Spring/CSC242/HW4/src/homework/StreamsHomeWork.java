package homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsHomeWork {

    /**
     * This function is given a List of Strings you need to create a comparator that sorts the list of strings in
     * ascending order based off of the total sum of all the characters encoding index. Then return the sorted list.
     *
     * The total sum of the characters indexes can be computed by converting each character in the string into an int,
     * then add all the numbers together. For example if given the string "hello" the characters index representation of the
     * string is as follows [104, 100, 108, 108, 111], where 'h' = 104, 'o' = 100 and so on. The sum of all the indexes
     * is equal to 531. Then the function should compare that sum with the other word's character sum to compute the word
     * ordering.
     *
     * <br><br>
     * This Function must take no longer 1000 milliseconds to return.
     *
     * @param collection a List of words
     * @return A sorted List of words in ascending order based on the sum of their character indexes.
     */
    public static List sortCharSum(List collection){
        Object[] words = collection.toArray();
        int[] wordsValue = new int[words.length];

        for (int i = 0; i < words.length; i++){
            wordsValue[i] = turnWordIntoNumber(String.valueOf(words[i]));
        }

        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if (wordsValue[i] > wordsValue[j]){
                    int tempValue = wordsValue[j];
                    wordsValue[j] = wordsValue[i];
                    wordsValue[i] = tempValue;
                    Object tempObjectValue = words[j];
                    words[j] = words[i];
                    words[i] = tempObjectValue;
                }
            }
        }

        return Arrays.asList(words.clone());
    }

    public static int turnWordIntoNumber(String word){
        int totalSum = 0;
        for (int i = 0; i < word.length(); i++){
            totalSum += Integer.valueOf(word.charAt(i));
        }
        return totalSum;
    }

    /**
     * This function is given a collection. It will return a stream of the collection.
     *
     * <br><br>
     * This Function must take no longer 500 milliseconds to return.
     *
     * @param collection a collection (List or a Set) of objects
     * @return A stream of the collection
     */
    public static Stream getStream(Collection collection){
        return collection.stream();
    }

    /**
     * This function is given a collection. It will return a parallel stream of the collection.
     *
     * <br><br>
     * This Function must take no longer 500 milliseconds to return.
     *
     * @param collection a collection (List or a Set) of objects
     * @return A stream of the collection that is parallel
     */
    public static Stream getParallelStream(Collection collection){
        return collection.parallelStream();
    }

    /**
     * This function will convert a stream of objects into a list of strings. Each string in the list is the string
     * representation of the object. Map each object in the stream to a string and collect it into a list.
     *
     * <br><br>
     * This Function must take no longer 500 milliseconds to return.
     *
     * @param stream A stream of objects
     * @return A list of strings
     */
    public static List<String> convertStreamToStrings(Stream<? extends Object> stream){
        return stream.map(o -> o.toString()).collect(Collectors.toList());
    }

    /**
     * This function will filter out all the numbers in the stream that are divisible by the divisor number. Then
     * raise the filtered number to the power number. Example: (n=filtered number) n^power. And finally collect all
     * the numbers in a set.
     *
     * <br><br>
     * This Function must take no longer 70 milliseconds to return.
     *
     * @param power A number that the numbers that the divisible numbers will be raised to.
     * @param divisor A number that the numbers in the stream must be divisible by.
     * @param stream A stream of integers.
     * @return A set of numbers
     */
    public static Set<Integer> powerDivisibleNumbers(int power, int divisor, Stream<Integer> stream){
        return stream.filter(n->(n % divisor == 0)).map(n->(int)Math.pow(n,power)).collect(Collectors.toSet());
    }

    /**
     * This function is given a stream of lists containing integers. You must return a set of all of numbers that are
     * found in the streams sub-lists that are contained in the filter list. In other words, flatten the stream then
     * filter the numbers based on if they are contained in the filter list.
     *
     *<br><br>
     *This Function must take no longer 70 milliseconds to return.
     *
     * @param filterList A list of numbers
     * @param stream A stream of lists that contain numbers
     * @return A set of numbers found in the stream sub-lists that are equal to at least one number in the Filter List.
     */
    public static Set<Integer> flatFilteredMap(List<Integer> filterList, Stream<List<Integer>> stream){
        Set<Integer> setToReturn = new HashSet<Integer>();
        List<List> listOfList = stream.collect(Collectors.toList());
        for (int numberInFilteredList : filterList){
            for (List list : listOfList){
                for (Object num : list){
                    if ((int) num == numberInFilteredList){
                        setToReturn.add((int)num);
                    }
                }
            }
        }
        return setToReturn;
    }

    /**
     * This function is given a stream of strings and it is your job to convert the strings to a Map. The map's key are
     * the strings in the stream and the values are the strings in reverse order.
     * <br><br>
     * This Function must take no longer 70 milliseconds to return.
     * @param stream A stream of strings
     * @return A map with key equal to the strings in the stream and values equal to strings that are the reverse of the
     * keys
     */
    public static Map<String, String> toMap(Stream<String> stream){
        return stream.collect(Collectors.toMap(str -> str, str -> reverseString(str)));
    }

    public static String reverseString(String incomingStr){
        byte[] strAsByteArray = incomingStr.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        return new String(result);
    }
    /**
     * This function will receive a stream of strings and it will return a sorted list of strings that meet all of the
     * following criteria:
     * <br><br>
     * 1) They must contain the pattern
     * <br>
     * 2) The strings length must be equal to or greater than the min length number
     * <br>
     * 3) The strings length must be an even or odd number
     * <br><br>
     *
     * The list returned must be sorted by the length of each string (low to high).
     * <br><br>
     * This Function must take no longer 150 milliseconds to return.
     *
     * @param pattern A pattern that all the strings in the list returned must contain
     * @param minLength The length that all the strings in the list returned must be equal to or greater than
     * @param even True if even false if odd. Denotes a condition that all the strings in the list returned must have a
     *             length that is even or odd.
     * @param stream A stream of strings to be filtered
     * @return A list of strings that meets the criteria outlined above sorted by their length from small to large
     */
    public static List<String> findWinners(String pattern, int minLength, boolean even, Stream<String> stream){
        List<String> listToReturn = new ArrayList<String>();
        Object[] arrayOfStr = stream.toArray();
        for (Object o : arrayOfStr){
            if (String.valueOf(o).contains(pattern) && (String.valueOf(o).length() >= minLength) && (String.valueOf(o).length() % 2 == 0) == even){
                listToReturn.add(String.valueOf(o));
            }
        }

//        return stream
//                .filter(word->(doesStringHavePattern(word, pattern) && (word.length() >= minLength) && ((word.length() % 2 == 0) && even)))
//                .collect(Collectors.toList());

        return listToReturn;
    }
//
//    public static boolean doesStringHavePattern(String original, String pattern){
//        int minimumLength = 0;
//        if (original.length() <= pattern.length()){
//            minimumLength = original.length();
//        } else {
//            minimumLength = pattern.length();
//        }
//
////        System.out.println("Minimum Length of string is = " + minimumLength);
//        for(int i = 0; i < minimumLength; i++){
//            if (original.charAt(i) != pattern.charAt(i))
//                return false;
//        }
//        return true;
//    }


    /**
     * THIS FUNCTION IS NOT REQUIRED
     *
     *
     * This function will return a list of strings from the stream that do not contain any of the strings found in the
     * losers set as a substring. A substring means that one string is found with in the other string or they are equal.
     * <br>
     * <br>
     * In other words this function will look at each string in the stream and test if the string contains any of the
     * strings in the loser set as a substring. All strings from the stream that do not contain a string in the loser
     * set as a substring are collected in a list and returned.
     * <br>
     * <br>
     * Example:
     * <br>
     * stream = ('Hello', 'Happy', 'Zappos')
     * <br>
     * losers = ('ell', 'pos')
     * <br>
     * returned = ['Happy']
     * <br>
     * @param losers A set of sub strings that the returned strings cannot contain
     * @param stream A stream of strings that will be filtered
     * @return A list of strings the do not contain any of the strings in the loser set as sub strings
     */
     public static List<String> filterLosers(Set<String> losers, Stream<String> stream){
         return null;
    }
}
