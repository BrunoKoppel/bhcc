package trie;

public class Main {

    public static void main(String[] args) {
        String s1 = "Mother";
        String s2 = "!ovie";
        String s3 = "Mountain";
        String s4 = "amazon";
        String s5 = "pre-requisite";
        String s6 = "prescholar";
        String s10 = "0x0coltsfoots";
        String s11 = "0x0forestaff";
        String s12 = "0x0unaffordable";
        String s13 = "0x0forest-bred";
        String s14 = "0x0ingoted";
        String s15 = "0x0valvulotomy";
        String s16 = "0x0ainslie";
        String s17 = "0x0unrealist";
        String s18 = "0x0mythogonic";
        String s19 = "0x0cayce";

        Integer a = 0;

        Trie one = new Trie();
        one.insert(s1);
        one.insert(s2);
        one.insert(s3);
        one.insert(String.valueOf(a));
        one.insert(s11);
        one.insert(s12);
        one.insert(s13);
        one.insert(s14);
        one.insert(s15);
        System.out.println(one.contains(s1));
        System.out.println(one.contains(s2));
        System.out.println(one.contains(s3));
        System.out.println(one.contains(s10));
        System.out.println(one.contains(s11));
        System.out.println(one.contains(s13));
        System.out.println(one.contains(s14));
        System.out.println(one.contains(s15));
        System.out.println(one.contains(s16));
        System.out.println(one.getAllWords(""));
        System.out.println(one.getAllWords(null + ""));
        System.out.println(one.getAllEvenWords("Mo"));
        System.out.println(one.getAllOddWords("Mo"));

//        System.out.println("Testing letter to int");
//        for (int i = 0; i < 256; i++){
//            char letter = (char)i;
//            System.out.println(i + ": " + letter + " => " + one.letterToInt(letter) );
//        }
    }
}
