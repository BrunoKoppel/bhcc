package trie;

public class Main {

    public static void main(String[] args) {
        String s1 = "Mother";
        String s2 = "!ovie";
        String s3 = "Mountain";
        String s4 = "amazon";
        String s5 = "pre-requisite";
        String s6 = "prescholar";
        String s8 = "0x0unaffordable";

        Trie one = new Trie();
        one.insert(s1);
        one.insert(s2);
        one.insert(s3);
        one.insert(s4);
        one.insert(s5);
        one.insert(s8);
        System.out.println(one.contains(s1));
        System.out.println(one.contains(s2));
        System.out.println(one.contains(s3));
        System.out.println(one.contains(s4));
        System.out.println(one.contains(s5));
        System.out.println(one.contains(s8));
        System.out.println(one.getAllWords(""));
        System.out.println(one.getAllEvenWords("Mo"));
        System.out.println(one.getAllOddWords("Mo"));

//        System.out.println("Testing letter to int");
//        for (int i = 0; i < 256; i++){
//            char letter = (char)i;
//            System.out.println(i + ": " + letter + " => " + one.letterToInt(letter) );
//        }
    }
}
