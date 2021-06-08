package homework1;

public class Main {
    public static boolean Problem1 = false;
    public static boolean Problem2 = false;
    public static boolean Problem3 = false;
    public static boolean Problem4 = true;
    public static boolean VERBOSE = false;


    public static void main(String[] args) {

        if (Problem1){
            System.out.println("Dance Counter Problem:");
            System.out.println("Test #1:");
            System.out.println(testResult(compareArrays(Homework1.findMinMax(new int[]{1, -2, 5, 1, 7, -2, -4, 2}),(new int[]{1,4}))));
            System.out.println("Test #2:");
            System.out.println(testResult(compareArrays(Homework1.findMinMax(new int[]{2,-2,0,8,5,-5}),(new int[]{1,4}))));
        }

        if (Problem2){
            System.out.println("Clean the Data Problem:");
            System.out.println("Test #1:");
            System.out.println(testResult(compareArrays(Homework1.removeDup(new int[]{ 1, 2, 5, 1, 7, 2, 4, 2}),(new int[]{1, 2, 5, 7, 4}))));
        }

        if (Problem3){
            System.out.println("Create a Word Mirror:");
            System.out.println("Test #1:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("aebcbda"),2)));
            System.out.println("Test #2:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("yjuwejqovdmacvovyvgtyiqr"),17)));
            System.out.println("Test #3:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("pxgkxysgaapesbjuyftfnjg"),15)));
            System.out.println("Test #4:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("hbhjdqmbedxnugcxcux"),12)));
            System.out.println("Test #5:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("rxaebgvdbycvtrvftsjvonheiv"),19)));
            System.out.println("Test #6:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("tmmgsuntfrurgfhd"),11)));
            System.out.println("Test #7:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("hisoucjehwlykilirotxhpj"),16)));
            System.out.println("Test #8:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("dlpsrqewkuubgfgyozplpnwk"),17)));
            System.out.println("Test #9:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("ltzolymiguanulyau"),12)));
            System.out.println("Test #10:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("rfubigblnydirnwjjkartehuyj"),20)));
            System.out.println("Test #11:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("owuekolxzmljvdckbzfsgnjqqwy"),20)));
            System.out.println("Test #12:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("uaiabweujkqvxibgg"),12)));
            System.out.println("Test #13:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("rzbnkngwheccrb"),9)));
            System.out.println("Test #14:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("vvkiiuxbbfucuioxjcm"),13)));
            System.out.println("Test #15:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("sbwdskzobryecmcmjcqaf"),16)));
            System.out.println("Test #16:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("wrukopzahszktugoaeuulkkyfp"),19)));
            System.out.println("Test #17:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("dowhjqhuebwwilspg"),12)));
            System.out.println("Test #18:");
            System.out.println(testResult(compareOutput(Homework1.createMirror("cirsfrvdwyum"),9)));
        }

        if (Problem4){
            System.out.println("Power Company Problem:");
            System.out.println("Test #1:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(2,10),4)));
            System.out.println("Test #2:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(7,71),7)));
            System.out.println("Test #3:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(13,44),6)));
            System.out.println("Test #4:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(14,9),4)));
            System.out.println("Test #5:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(15,47),6)));
            System.out.println("Test #6:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(10,41),6)));
            System.out.println("Test #7:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(8,73),7)));
            System.out.println("Test #8:");
            System.out.println(testResult(compareOutput(Homework1.minVisits(9,25),5)));
        }
    }

    public static String testResult(boolean c){
        if (c){
            return  "SUCCEEDED";
        } else {
            return "FAILED!!!";
        }
    }

    public static boolean compareArrays(int [] array1, int [] array2){
        if (VERBOSE){
            System.out.println("Size of the first array is: " + array1.length);
            System.out.println("Size of the seconds array is: " + array2.length);
        }

        for (int index = 0; index < array2.length; index++){
            if(VERBOSE)
                System.out.println(array1[index] + " vs " + array2[index]);

            if (array1[index] != array2[index])
                return false;
        }
        return true;
    }

    public static boolean compareOutput(int receivedOutput, int expectedOutput){
        System.out.print("Received Output: " + receivedOutput + " and Expected Output: " + expectedOutput + " => ");
        return (receivedOutput == expectedOutput);
    }
}
